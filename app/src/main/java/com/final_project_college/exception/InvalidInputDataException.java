package com.final_project_college.exception;

public class InvalidInputDataException extends Exception {
    /**
     * Default exception constructor.
     */
    public InvalidInputDataException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public InvalidInputDataException(String message) {
        super(message);
    }

    public InvalidInputDataException(Throwable e) {
        super(e);
    }
}
