package com.final_project_college.service.impl;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.AbstractDaoFactory;
import com.final_project_college.dao.jdbc.impl.DefaultTransactionManager;
import com.final_project_college.dao.old.ExpositionDao;
import com.final_project_college.dao.impl.mysql.MySqlDaoFactory;
import com.final_project_college.dto.old.Exposition;
import com.final_project_college.service.ExpositionService;
import com.final_project_college.util.ContextMapper;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExpositionServiceImplTest {
    @Test
    public void findAllExpositions() throws Exception {
        ServletContext servletContext = PowerMockito.mock(ServletContext.class);
        AbstractDaoFactory daoFactory = mock(MySqlDaoFactory.class);
        ConnectionWrapper connectionWrapper = PowerMockito.mock(ConnectionWrapper.class);
        ExpositionDao expositionDao = mock(ExpositionDao.class);
        DefaultTransactionManager transactionManager = mock(DefaultTransactionManager.class);
        Exposition exposition1 = Exposition.getEmptyExposition();
        Exposition exposition2 = Exposition.getEmptyExposition();
        List<Exposition> expected = Arrays.asList(exposition1, exposition2);

        when(daoFactory.getExpositionDao(connectionWrapper)).thenReturn(expositionDao);
        when(expositionDao.findAllPaginated(0, 2)).thenReturn(expected);
        when(servletContext.getAttribute("mySqlDaoFactory")).thenReturn(daoFactory);
        when(servletContext.getAttribute("transactionManager")).thenReturn(transactionManager);
        when(transactionManager.getConnection()).thenReturn(connectionWrapper);

        ContextMapper.INSTANCE.setServletContext(servletContext);

        ExpositionService expositionService = new ExpositionServiceImpl();
        List<Exposition> actual = expositionService.findAllExpositions(0, 2);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}