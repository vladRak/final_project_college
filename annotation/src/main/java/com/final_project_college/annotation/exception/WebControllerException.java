package com.final_project_college.annotation.exception;

public class WebControllerException extends Exception {
    /**
     * Default exception constructor.
     */
    public WebControllerException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public WebControllerException(String message) {
        super(message);
    }

    public WebControllerException(Throwable e) {
        super(e);
    }
}