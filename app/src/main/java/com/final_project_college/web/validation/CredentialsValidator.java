package com.final_project_college.web.validation;

import com.final_project_college.annotation.AdminCredentials;
import com.final_project_college.annotation.Controller;
import com.final_project_college.annotation.exception.CredentialsException;
import com.final_project_college.web.filter.WebRole;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

public class CredentialsValidator {

    public boolean validateCredentials(Controller controller, HttpServletRequest request)
            throws CredentialsException {
        boolean valid;
        if (nonNull(controller) && controller.getClass().isAnnotationPresent(AdminCredentials.class)) {
            String role = (String) request.getSession().getAttribute("role");
            if (nonNull(role) && role.equals(WebRole.ADMIN.name())) {
                valid = true;
            } else throw new CredentialsException("Unsupported controller for credentials");
        } else if (nonNull(controller)) {
            valid = true;
        } else throw new CredentialsException("Unsupported controller for credentials");

        return valid;
    }
}
