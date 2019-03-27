package com.final_project_college.web.controller.applicant;

import com.final_project_college.annotation.WebController;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicantService;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

import static com.final_project_college.util.ControllerUtil.validateApplicant;
import static com.final_project_college.util.ControllerUtil.validateUser;

@WebController("applicantRegister")
public class ApplicantRegisterController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("register");
        else {
            try {
                Map<String, String[]> params = request.getParameterMap();

                ApplicantService applicantService = serviceFactory.getApplicantService();

                applicantService.registerApplicant(validateApplicant(params), validateUser(params));

                request.setAttribute("message",
                        "Applicant created successfully. Confirm your email.");
                forward("register");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BusinessException e) {
                request.setAttribute("message",
                        e.getMessage() + e.getCode().getMsg());
                forward("register");
            }
        }
    }
}