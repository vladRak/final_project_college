package com.final_project_college.exception;

public class RegistrationException extends Exception {
    /**
     * Default exception constructor.
     */
    public RegistrationException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(Throwable e) {
        super(e);
    }
}
