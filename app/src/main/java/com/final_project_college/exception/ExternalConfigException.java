package com.final_project_college.exception;

public class ExternalConfigException extends Exception {
    /**
     * Default exception constructor.
     */
    public ExternalConfigException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public ExternalConfigException(String message) {
        super(message);
    }

    public ExternalConfigException(Throwable e) {
        super(e);
    }
}