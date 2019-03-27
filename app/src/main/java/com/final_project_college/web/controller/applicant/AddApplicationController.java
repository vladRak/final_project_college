package com.final_project_college.web.controller.applicant;

import com.final_project_college.annotation.WebController;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicantService;
import com.final_project_college.service.ApplicationService;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.final_project_college.util.ControllerUtil.*;

@WebController("addApplication")
public class AddApplicationController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("applications");
        else {
            try {
                Map<String, String[]> params = request.getParameterMap();

                ApplicationService applicationService = serviceFactory.getApplicationService();

                applicationService.addApplication(validateApplication(params),
                        request.getParameter("email"));

                request.setAttribute("message",
                        "Application created successfully.");
                forward("applications");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BusinessException e) {
                request.setAttribute("message",
                        e.getMessage() + e.getCode().getMsg());
                forward("applications");
            }
        }
    }
}