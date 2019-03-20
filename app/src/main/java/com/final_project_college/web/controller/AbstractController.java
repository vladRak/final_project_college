package com.final_project_college.web.controller;

import com.final_project_college.annotation.Controller;
import com.final_project_college.util.PagePathManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class AbstractController implements Controller {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
        this.session = request.getSession();
    }

    public abstract void process() throws ServletException, IOException;

    public void forward(String target) throws ServletException, IOException {
        String page = PagePathManager.INSTANCE.getPageByName(target);

        System.out.println("Abstract controller: " + target);
        response.setStatus(HttpServletResponse.SC_OK);
        RequestDispatcher dispatcher = context.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected int getNOfPages(int rows, int recordsPerPage) {
        int nOfPages = rows / recordsPerPage;

        if (rows % recordsPerPage > 0) {
            nOfPages++;
        }

        return nOfPages;
    }

    protected int getStart(int currentPage, int recordsPerPage) {
        int start;
        if (currentPage == 1) {
            start = 0;
        } else {
            start = (currentPage - 1) * recordsPerPage;
        }
        return start;
    }
}