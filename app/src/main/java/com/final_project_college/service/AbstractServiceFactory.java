package com.final_project_college.service;

import com.final_project_college.exception.DataAccessException;

public interface AbstractServiceFactory {

    ExpositionService getExpositionService() throws DataAccessException;

    HallService getHallService() throws DataAccessException;

    PaymentService getPaymentService() throws DataAccessException;

    RoleService getRoleService() throws DataAccessException;

    TicketService getTicketService() throws DataAccessException;

    UserService getUserService() throws DataAccessException;
}