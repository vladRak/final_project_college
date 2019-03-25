package com.final_project_college.web.controller.common;

import com.final_project_college.annotation.Credentials;
import com.final_project_college.annotation.WebController;
import com.final_project_college.web.controller.AbstractController;

import javax.servlet.ServletException;
import java.io.IOException;

@WebController("logout")
@Credentials(value = {"ADMIN", "MODERATOR", "APPLICANT"})
public class LogoutController extends AbstractController {
    @Override
    public void process() throws ServletException, IOException {
        session.invalidate();
        response.sendRedirect("/");
    }
}
