package com.final_project_college.web.controller.common;

import com.final_project_college.annotation.Credentials;
import com.final_project_college.annotation.WebController;
import com.final_project_college.domain.dto.Role;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.UserService;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.stream.Stream;

@WebController("login")
public class LoginController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("login");
        else {
            try {
                UserService userService = serviceFactory.getUserService();

                User user = userService.getVerifiedUser(
                        request.getParameter("email"),
                        request.getParameter("password"));
                Role role = userService.getUserRole(user);

                sessionSetAttributes(Stream.of(
                        attribute("password", user.getPassword()),
                        attribute("email", user.getEMail()),
                        attribute("role", role.getRoleName()),
                        attribute("recordsPerPage", 2)
                        ).collect(attributesMap())
                );

                forward("home");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                forward("login");
            } catch (BusinessException e) {
                request.setAttribute("errorMessage", e.getMessage());
                forward("login");
            }
        }
    }
}