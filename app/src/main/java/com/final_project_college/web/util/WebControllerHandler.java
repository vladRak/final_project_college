package com.final_project_college.web.util;

import com.final_project_college.annotation.WebController;
import com.final_project_college.annotation.exception.WebControllerException;
import org.reflections.Reflections;

import java.util.*;

import static java.util.Objects.nonNull;

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

    public Class<?> getController(String command) throws WebControllerException {
        Class clazz = commands.get(command);
        if (nonNull(clazz)) return clazz;
        else throw new WebControllerException("Unsupported controller: " + command);
    }
}
