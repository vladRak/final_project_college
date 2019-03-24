package com.final_project_college.web.controller.applicant;

import com.final_project_college.annotation.WebController;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.SystemException;
import com.final_project_college.service.ApplicantService;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.stream.Stream;

@WebController("login")
public class ApplicantRegistrationController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("register");
        else {
            try {
                ApplicantService applicantService = serviceFactory.getApplicantService();

                applicantService.registerApplicant(applicant, schoolExams, user);

                sessionSetAttributes(Stream.of(
                        attribute("recordsPerPage", 2)
                        ).collect(attributesMap())
                );

                request.setAttribute("successMessage", message);
                forward("success");

            } catch (SystemException e) {
                logger.error(e.getMessage());
                forward("login");
            } catch (BusinessException e) {
                request.setAttribute("errorMessage", e.getMessage());
                forward("register");
            }
        }
    }
}