package com.final_project_college.exception;

/**
 * The DataAccessException wraps all checked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class DataAccessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ExceptionCode code;

    public DataAccessException(ExceptionCode code) {
        this.code = code;
    }

    public DataAccessException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }

    public DataAccessException(Throwable cause, ExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public DataAccessException(String message, Throwable cause, ExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
