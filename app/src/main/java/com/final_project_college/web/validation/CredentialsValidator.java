package com.final_project_college.web.validation;

import com.final_project_college.annotation.Controller;
import com.final_project_college.annotation.Credentials;
import com.final_project_college.annotation.exception.AnnotationException;
import com.final_project_college.annotation.exception.AnnotationExceptionCode;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CredentialsValidator {

    public boolean validateCredentials(Controller controller, String role) {

        if (getAllowed(controller).contains(checkRole(role))) {
            return true;
        } else throw new AnnotationException(
                "Unsupported controller for credentials1",
                AnnotationExceptionCode.CREDENTIALS_EXCEPTION);
    }

    private String checkRole(String role) {
        return Optional.ofNullable(role).orElseThrow(() -> new AnnotationException(
                "Unsupported controller for credentials2",
                AnnotationExceptionCode.CREDENTIALS_EXCEPTION));
    }

    private List<String> getAllowed(Controller controller) {
        return Arrays.asList(controller.getClass().getAnnotation(Credentials.class).value());
    }
}
