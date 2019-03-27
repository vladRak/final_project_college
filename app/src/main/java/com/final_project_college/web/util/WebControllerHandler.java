package com.final_project_college.web.util;

import com.final_project_college.annotation.WebController;
import com.final_project_college.annotation.exception.AnnotationException;
import com.final_project_college.annotation.exception.AnnotationExceptionCode;
import org.reflections.Reflections;

import java.util.*;

public enum WebControllerHandler {

    INSTANCE;

    private final static Map<String, Class<?>> commands;

    static {
        Reflections reflections = new Reflections("com.final_project_college");

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(WebController.class);

        Map<String, Class<?>> var = new HashMap<>();
        for (Class<?> clazz : annotated) {
            WebController webController = clazz.getAnnotation(WebController.class);
            var.put(webController.value(), clazz);
        }

        commands = Collections.unmodifiableMap(new LinkedHashMap<>(var));
    }

    public Class<?> getController(String command) {
        return Optional.of(commands.get(command)).orElseThrow(() ->
                new AnnotationException("Unsupported controller: " + command,
                        AnnotationExceptionCode.WEB_CONTROLLER_EXCEPTION));
    }
}
