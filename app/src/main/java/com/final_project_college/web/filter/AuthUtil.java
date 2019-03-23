package com.final_project_college.web.filter;

import com.final_project_college.dao.AbstractDaoFactory;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.VerificationException;
import com.final_project_college.service.RoleService;
import com.final_project_college.service.UserService;
import com.final_project_college.service.impl.ServiceFactory;
import com.final_project_college.util.ContextMapper;

public class AuthUtil {

    private final AbstractDaoFactory daoFactory;
    private final ContextMapper contextMapper;

    public AuthUtil() throws DataAccessException {
        contextMapper = ContextMapper.INSTANCE;
        daoFactory = contextMapper.getDaoFactory();
    }

    public String getRoleName(String email, String password) throws VerificationException, DataAccessException {
        ServiceFactory serviceFactory = contextMapper.getServiceFactory();
        UserService userService = serviceFactory.getUserService();
        RoleService roleService = serviceFactory.getRoleService();
        User user = userService.getVerifiedUser(email, password);
        Role role = roleService.getRoleById(user.getRoleId());
        return role.getRoleName();
    }
}
