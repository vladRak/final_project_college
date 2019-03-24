package com.final_project_college.web.util;

import com.final_project_college.annotation.Controller;
import com.final_project_college.util.ContextMapper;

import javax.servlet.http.HttpServletRequest;

public class DispatcherUtils {

    private final static ContextMapper contextMapper = ContextMapper.INSTANCE;

    public static Controller getController(HttpServletRequest request) {
        final String requestController = getCommandFromRequest(request);

        Controller controller = null;
        try {
            controller = (Controller) contextMapper
                    .getWebControllerHandler()
                    .getController(requestController)
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return controller;
    }

    public static String getCommandFromRequest(HttpServletRequest request){
        return request.getParameter("controller");
    }

    public static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
