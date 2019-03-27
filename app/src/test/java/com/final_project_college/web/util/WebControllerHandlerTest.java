//package com.final_project_college.web.util;
//
//import com.final_project_college.annotation.Controller;
//import com.final_project_college.web.controller.common.LoginController;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class WebControllerHandlerTest {
//
//    @Test
//    public void getExistController() throws Exception {
//        final String requestController = "login";
//        WebControllerHandler webControllerHandler = WebControllerHandler.INSTANCE;
//
//        Controller controller = (Controller) webControllerHandler
//                .getController(requestController)
//                .newInstance();
//
//
//        assertNotNull(controller);
//        assertEquals(LoginController.class, controller.getClass());
//    }
//
//    @Test(expected = WebControllerException.class)
//    public void getNotExistControllerThrowException() throws Exception {
//        final String requestController = "olologin";
//        WebControllerHandler webControllerHandler = WebControllerHandler.INSTANCE;
//
//        Controller controller = (Controller) webControllerHandler
//                .getController(requestController)
//                .newInstance();
//    }
//
//}