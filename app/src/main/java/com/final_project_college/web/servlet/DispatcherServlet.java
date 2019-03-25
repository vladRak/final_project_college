package com.final_project_college.web.servlet;

import com.final_project_college.annotation.Controller;
import com.final_project_college.annotation.exception.AnnotationException;
import com.final_project_college.util.ContextMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.final_project_college.web.util.DispatcherUtils.*;

public class DispatcherServlet extends HttpServlet {

    private final static ContextMapper contextMapper = ContextMapper.INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Controller controller = getController(request);
            System.out.println(controller);

            contextMapper
                    .getCredentialsValidator()
                    .validateCredentials(controller, getRole(request));

            controller.init(getServletContext(), request, response);
            controller.process();

        } catch (AnnotationException e) {
            switch (e.getCode()) {
                case CREDENTIALS_EXCEPTION:
                    logger.error("IP: " + getClientIp(request) + " " + e.getMessage());
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    break;
                case WEB_CONTROLLER_EXCEPTION:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }
    }
}
