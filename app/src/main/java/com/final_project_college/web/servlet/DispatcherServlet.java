package com.final_project_college.web.servlet;

import com.final_project_college.annotation.Controller;
import com.final_project_college.annotation.exception.CredentialsException;
import com.final_project_college.annotation.exception.WebControllerException;
import com.final_project_college.util.ContextMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.final_project_college.web.util.DispatcherUtils.getClientIp;
import static com.final_project_college.web.util.DispatcherUtils.getController;

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
                    .validateCredentials(controller, request);

            controller.init(getServletContext(), request, response);
            controller.process();

        } catch (WebControllerException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (CredentialsException e) {
            logger.error("IP: " + getClientIp(request)+ " " + e.getMessage());
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
