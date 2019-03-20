package com.final_project_college.web.listener;

import com.final_project_college.connection.impl.ConnectionPoolImpl;
import com.final_project_college.dao.impl.mysql.MySQLDaoFactory;
import com.final_project_college.dao.transactions.TransactionManager;
import com.final_project_college.service.impl.ServiceFactory;
import com.final_project_college.util.ContextMapper;
import com.final_project_college.web.util.WebControllerHandler;
import com.final_project_college.web.validation.CredentialsValidator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        ContextMapper.INSTANCE.setServletContext(servletContext);
        servletContext.setAttribute("transactionManager", new TransactionManager(ConnectionPoolImpl.INSTANCE));
        servletContext.setAttribute("webControllerHandler", WebControllerHandler.INSTANCE);
        servletContext.setAttribute("serviceFactory", new ServiceFactory());
        servletContext.setAttribute("mySqlDaoFactory", new MySQLDaoFactory());
        servletContext.setAttribute("credentialsValidator", new CredentialsValidator());
        servletContext.setAttribute("serviceFactory", new ServiceFactory());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}