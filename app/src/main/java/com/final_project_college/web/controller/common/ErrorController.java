package com.final_project_college.web.controller.common;

import com.final_project_college.annotation.WebController;
import com.final_project_college.web.controller.AbstractController;

import javax.servlet.ServletException;
import java.io.IOException;

@WebController("error")
public class ErrorController extends AbstractController {
    @Override
    public void process() throws ServletException, IOException {
        int status = response.getStatus();
        request.setAttribute("error", status);
        forward("error");
    }
}
