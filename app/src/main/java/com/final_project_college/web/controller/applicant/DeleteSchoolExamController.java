package com.final_project_college.web.controller.applicant;

import com.final_project_college.annotation.WebController;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.service.ApplicationService;
import com.final_project_college.service.SchoolExamService;
import com.final_project_college.web.controller.AbstractController;
import com.final_project_college.web.controller.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.final_project_college.util.ControllerUtil.getValidId;

@WebController("deleteSchoolExam")
public class DeleteSchoolExamController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET.name())) forward("school_exam");
        else {
            try {
                Map<String, String[]> params = request.getParameterMap();

                SchoolExamService schoolExamService = serviceFactory.getSchoolExamService();

                schoolExamService.deleteSchoolExam(getValidId(request.getParameter("schoolExamId")),
                        request.getParameter("email"));

                request.setAttribute("message",
                        "School exam deleted");
                forward("school_exam");

            } catch (DataAccessException e) {
                logger.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (BusinessException e) {
                request.setAttribute("message",
                        e.getMessage() + e.getCode().getMsg());
                forward("school_exam");
            }
        }
    }
}
