package com.final_project_college.web.controller.moderator;

import com.final_project_college.annotation.Credentials;
import com.final_project_college.annotation.WebController;
import com.final_project_college.web.controller.AbstractController;

import javax.servlet.ServletException;
import java.io.IOException;

@WebController("moderator")
@Credentials("MODERATOR")
public class ModeratorController extends AbstractController {

    @Override
    public void process() throws ServletException, IOException {
        forward("moderator");
    }
}