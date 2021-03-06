package com.final_project_college.web.controller.admin;

import com.final_project_college.annotation.Credentials;
import com.final_project_college.annotation.WebController;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicantService;
import com.final_project_college.service.UserService;
import com.final_project_college.service.impl.ServiceFactory;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

import static com.final_project_college.util.ControllerUtil.validateApplicant;
import static com.final_project_college.util.ControllerUtil.validateUser;

@WebController("userRegister")
@Credentials("ADMIN")
public class RegisterUserController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("user_register");
        else {
            try {
                Map<String, String[]> params = request.getParameterMap();

                UserService userService = serviceFactory.getUserService();

                userService.registerUser(validateUser(params));

                request.setAttribute("message",
                        "User created successfully");
                forward("user_register");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BusinessException e) {
                request.setAttribute("message",
                        e.getMessage() + e.getCode().getMsg());
                forward("user_register");
            }
        }
    }
}