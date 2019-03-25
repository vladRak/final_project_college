package com.final_project_college.service.impl;

import com.final_project_college.dao.AbstractDaoFactory;
import com.final_project_college.dao.jdbc.TransactionManager;
import com.final_project_college.util.ContextMapper;

import static java.util.Objects.nonNull;

public abstract class AbstractService {

    protected ContextMapper contextMapper;
    protected TransactionManager transactionManager;
    protected AbstractDaoFactory daoFactory;

    public AbstractService() {
        contextMapper = ContextMapper.INSTANCE;
        transactionManager = contextMapper.getTransactionManager();
        daoFactory = contextMapper.getDaoFactory();
    }
}
