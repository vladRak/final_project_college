package com.final_project_college.web.controller;

import com.final_project_college.annotation.Controller;
import com.final_project_college.service.impl.ServiceFactory;
import com.final_project_college.util.MapHelper;
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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class AbstractController implements Controller {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ServiceFactory serviceFactory;
    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
//        this.session = request.getSession();
        this.session = request.getSession(false);
        serviceFactory = (ServiceFactory) context.getAttribute("serviceFactory");
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

    protected void sessionSetAttributes(Map<String, Object> attributes) {
        attributes.forEach((key, value) ->
                session.setAttribute(key, value));
    }

    protected void sessionRemoveAttributes(List<String> attributes) {
        attributes.forEach((attr) ->
                session.removeAttribute(attr));
    }

    protected void setRequestAttributes(Map<String, Object> attributes) {
        attributes.forEach((key, value) ->
                request.setAttribute(key, value));
    }

//    protected Map<String, String> getRequestParameters(List<String> parameters) {
//        return new HashMap<String, String>() {{
//            for (String s : parameters) {
//                put(s, request.getParameter(s));
//            }
//        }};
//    }

//    protected Map<String, String[]> getRequestParameters(List<String> parameters) {
////        return new HashMap<String, List<String>>() {{
////            for (String s : parameters) {
////                put(s, request.getParameterMap(s));
////            }
////        }};
//
//        Map<String, String[]> map = request.getParameterMap();
//        Set set = map.entrySet();
//        Iterator it = set.iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String[]> entry =
//                    (Map.Entry<String, String[]>) it.next();
//            String paramName = entry.getKey();
//            String[] paramValues = entry.getValue();
//
//
//
//
//            if (paramValues.length == 1) {
//                String paramValue = paramValues[0];
//                if (paramValue.length() == 0)
//                    out.println("<b>No Value</b>");
//                else
//                    out.println(paramValue);
//            } else {
//                out.println("<ul>");
//                for (int i = 0; i < paramValues.length; i++) {
//                    out.println("<li>" + paramValues[i] + "</li>");
//                }
//            }
//        }
//    }

    protected Map.Entry<String, Object> attribute(String key, Object value) {
        return MapHelper.entry(key, value);
    }

    protected static Collector<Map.Entry<String, Object>, ?, Map<String, Object>> attributesMap() {
        return MapHelper.entryToMap();
    }
}