package com.final_project_college.exception;

public class VerificationException extends Exception {
    /**
     * Default exception constructor.
     */
    public VerificationException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public VerificationException(String message) {
        super(message);
    }

    public VerificationException(Throwable e) {
        super(e);
    }
}
