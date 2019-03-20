package com.final_project_college.annotation.exception;

public class CredentialsException extends Exception{
    /**
     * Default exception constructor.
     */
    public CredentialsException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public CredentialsException(String message) {
        super(message);
    }

    public CredentialsException(Throwable e) {
        super(e);
    }
}
