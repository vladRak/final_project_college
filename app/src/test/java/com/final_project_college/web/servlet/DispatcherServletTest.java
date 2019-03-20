package com.final_project_college.web.servlet;

import com.final_project_college.util.ContextMapper;
import com.final_project_college.web.util.WebControllerHandler;
import com.final_project_college.web.validation.CredentialsValidator;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class DispatcherServletTest {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletConfig servletConfig = mock(ServletConfig.class);

        when(request.getParameter("controller")).thenReturn("login");
        when(request.getMethod()).thenReturn("GET");

        ServletContext servletContext = PowerMockito.mock(ServletContext.class);
        when(servletContext.getAttribute("webControllerHandler")).thenReturn(WebControllerHandler.INSTANCE);
        when(servletContext.getAttribute("credentialsValidator")).thenReturn(new CredentialsValidator());
        when(servletContext.getRequestDispatcher("/view/login.jsp")).thenReturn(mock(RequestDispatcher.class));

        ContextMapper.INSTANCE.setServletContext(servletContext);

        when(request.getParameter("controller")).thenReturn("login");

        DispatcherServlet dispatcherServlet = spy(new DispatcherServlet());
        dispatcherServlet.init(servletConfig);
        when(dispatcherServlet.getServletContext()).thenReturn(servletContext);


        dispatcherServlet.doPost(request, response);

        verify(request, atLeast(1)).getParameter("controller");
    }
}