package com.final_project_college.web.controller.applicant;

import com.final_project_college.annotation.Credentials;
import com.final_project_college.annotation.WebController;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.final_project_college.util.ControllerUtil.validateSchoolExam;

@WebController("addSchoolExam")
@Credentials("APPLICANT")
public class AddSchoolExamController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("addSchoolExam");
        else {
            try {
                serviceFactory
                        .getSchoolExamService()
                        .addSchoolExam(validateSchoolExam(request.getParameterMap()),
                                (String) session.getAttribute("email"));

                request.setAttribute("message",
                        "SchoolExam created successfully.");
                forward("addSchoolExam");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BusinessException e) {
                request.setAttribute("message",
                        e.getMessage() + e.getCode().getMsg());
                forward("addSchoolExam");
            }
        }
    }
}