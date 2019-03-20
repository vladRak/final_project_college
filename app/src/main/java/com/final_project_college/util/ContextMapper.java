package com.final_project_college.util;


import com.final_project_college.dao.AbstractDaoFactory;
import com.final_project_college.dao.transactions.TransactionManager;
import com.final_project_college.service.impl.ServiceFactory;
import com.final_project_college.web.util.WebControllerHandler;
import com.final_project_college.web.validation.CredentialsValidator;

import javax.servlet.ServletContext;

public enum ContextMapper {

    INSTANCE;

    private ServletContext servletContext;

    public void setServletContext(ServletContext context) {
        servletContext = context;
    }

    public AbstractDaoFactory getDaoFactory() {
        return (AbstractDaoFactory) servletContext.getAttribute("mySqlDaoFactory");
    }

    public ServiceFactory getServiceFactory() {
        return (ServiceFactory) servletContext.getAttribute("serviceFactory");
    }

    public TransactionManager getTransactionManager() {
        return (TransactionManager) servletContext.getAttribute("transactionManager");
    }

    public WebControllerHandler getWebControllerHandler() {
        return (WebControllerHandler) servletContext.getAttribute("webControllerHandler");
    }

    public CredentialsValidator getCredentialsValidator() {
        return (CredentialsValidator) servletContext.getAttribute("credentialsValidator");
    }
}
