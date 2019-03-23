package com.final_project_college.web.filter;

import com.final_project_college.exception.VerificationException;
import com.final_project_college.web.listener.SessionCounterListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    protected static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("email")) &&
                nonNull(session.getAttribute("password"))) {

            final String role = (String) session.getAttribute("role");

            moveToMenu(req, res, role);

        } else if (nonNull(email) && nonNull(password)) {
            String role = WebRole.ANONYMOUS.name();
            try {
                role = new AuthUtil().getRoleName(email, password);
            } catch (VerificationException | DataAccessException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }

            moveToMenu(req, res, role);

        } else {

            moveToMenu(req, res, WebRole.ANONYMOUS.name());
        }

        System.out.println("Sessions: " + SessionCounterListener.getTotalActiveSession());
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {

        final String requestURI = req.getRequestURI();
        final String requestCommand = req.getParameter("controller");

        System.out.println("Req URI: " + requestURI);
        System.out.println("Req controller: " + requestCommand);
        System.out.println(req.getLocale().toString());

        if (role.equals(WebRole.ADMIN.name()) || role.equals(WebRole.USER.name())) {
            System.out.println("Role identify");
            req.getRequestDispatcher(requestURI).forward(req, res);
        } else if (nonNull(requestCommand)) {
            if (requestCommand.equals("register") || requestCommand.equals("login")) {
                System.out.println("Move to register or login");
                req.getRequestDispatcher(requestURI).forward(req, res);
            } else {
                System.out.println("Command note null request been forward to index");
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        } else {
            System.out.println("Request been forward to index");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {
    }

}