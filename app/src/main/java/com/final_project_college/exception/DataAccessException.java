package com.final_project_college.exception;

public class DataAccessException extends Exception {
    /**
     * Default exception constructor.
     */
    public DataAccessException() {
    }

    /**
     * Exception with message constructor.
     *
     * @param message Message to pass to handler
     */
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(Throwable e) {
        super(e);
    }
}