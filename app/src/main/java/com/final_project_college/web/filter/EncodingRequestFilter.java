package com.final_project_college.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingRequestFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

}