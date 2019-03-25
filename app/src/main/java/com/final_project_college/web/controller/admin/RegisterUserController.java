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

                request.setAttribute("successMessage",
                        "User created successfully");
                forward("user_register");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BusinessException e) {
                request.setAttribute("errorMessage",
                        e.getMessage() + e.getCode().getMsg());
                forward("user_register");
            }
        }
    }





//    @Override
//    public void process() throws ServletException, IOException {
//        String method = request.getMethod();
//        if (method.equals(HttpMethod.GET.name())) forward("register");
//        else {
//
//            ServiceFactory serviceFactory = (ServiceFactory) context.getAttribute("serviceFactory");
//            User user = null;
//            try {
//                UserService userService = serviceFactory.getUserService();
//                user = userService.getUserFromRequest(request);
//                userService.registerUser(user);
//                forward("index");
//            } catch (DataAccessException e) {
//                logger.error(e.getMessage());
//                e.printStackTrace();
//                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            } catch (InvalidInputDataException e) {
//                logger.error(e.getMessage());
//                request.setAttribute("errorMessage", e.getMessage());
////                request.setAttribute("firstName", user.getFirstName());
////                request.setAttribute("lastName", user.getLastName());
//                request.setAttribute("email", user.getEMail());
//                forward("register");
//                e.printStackTrace();
//            }
//        }
//    }
}
