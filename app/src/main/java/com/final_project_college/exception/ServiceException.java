package com.final_project_college.exception;

public class ServiceException extends Exception {
    /**
     * Default exception constructor.
     */
    public ServiceException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable e) {
        super(e);
    }
}