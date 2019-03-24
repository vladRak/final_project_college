package com.final_project_college.web.filter;

import com.final_project_college.exception.SystemException;
import com.final_project_college.service.AbstractServiceFactory;
import com.final_project_college.service.UserService;
import com.final_project_college.util.ContextMapper;

public class AuthUtil {

    private final AbstractServiceFactory serviceFactory;
    private final ContextMapper contextMapper;

    public AuthUtil() {
        contextMapper = ContextMapper.INSTANCE;
        serviceFactory = contextMapper.getServiceFactory();
    }

    public String getRoleName(String email, String password) throws SystemException {
        UserService userService = serviceFactory.getUserService();
        return userService
                .getUserRole(userService
                        .getVerifiedUser(email, password))
                .getRoleName();
    }
}
