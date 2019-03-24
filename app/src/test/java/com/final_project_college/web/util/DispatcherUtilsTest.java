package com.final_project_college.web.util;

import com.final_project_college.annotation.Controller;
import com.final_project_college.util.ContextMapper;
import com.final_project_college.web.controller.common.LoginController;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class DispatcherUtilsTest {


    @Test
    public void getExistController() throws Exception {
        ServletContext servletContext = PowerMockito.mock(ServletContext.class);
        when(servletContext.getAttribute("webControllerHandler")).thenReturn(WebControllerHandler.INSTANCE);
        ContextMapper.INSTANCE.setServletContext(servletContext);
        HttpServletRequest httpServletRequest = PowerMockito.mock(HttpServletRequest.class);
        when(httpServletRequest.getParameter("controller")).thenReturn("login");

        Controller controller = DispatcherUtils.getController(httpServletRequest);

        assertNotNull(controller);
        assertEquals(controller.getClass(), LoginController.class);
    }


    @Test(expected = WebControllerException.class)
    public void getNotExistController() throws Exception {
        ServletContext servletContext = PowerMockito.mock(ServletContext.class);
        when(servletContext.getAttribute("webControllerHandler")).thenReturn(WebControllerHandler.INSTANCE);
        ContextMapper.INSTANCE.setServletContext(servletContext);
        HttpServletRequest httpServletRequest = PowerMockito.mock(HttpServletRequest.class);
        when(httpServletRequest.getParameter("controller")).thenReturn("olologin");

        DispatcherUtils.getController(httpServletRequest);
    }

    @Test
    public void getCommandFromRequest() throws Exception {
        HttpServletRequest httpServletRequest = PowerMockito.mock(HttpServletRequest.class);
        when(httpServletRequest.getParameter("controller")).thenReturn("login");

        String controllerName = DispatcherUtils.getCommandFromRequest(httpServletRequest);

        assertEquals("login",controllerName);
    }

}