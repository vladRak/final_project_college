package com.final_project_college.service.impl;

import com.final_project_college.dao.AbstractDaoFactory;
import com.final_project_college.dao.jdbc.TransactionManager;
import com.final_project_college.util.ContextMapper;

import javax.servlet.http.HttpServletRequest;

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

    protected boolean isValidString(String string) {
        return nonNull(string) && string.length() > 0;
    }

    protected long getValidId(HttpServletRequest request) throws InvalidInputDataException {
        String id = request.getParameter("id");
        if (isValidString(id)) return Long.parseLong(id);
        else throw new InvalidInputDataException("Invalid ID");
    }
}
