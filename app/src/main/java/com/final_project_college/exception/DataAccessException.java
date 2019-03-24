package com.final_project_college.exception;

/**
 * The DataAccessException wraps all checked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class DataAccessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final SystemCode code;

    public DataAccessException(SystemCode code) {
        this.code = code;
    }

    public DataAccessException(String message, SystemCode code) {
        super(message);
        this.code = code;
    }

    public DataAccessException(Throwable cause, SystemCode code) {
        super(cause);
        this.code = code;
    }

    public DataAccessException(String message, Throwable cause, SystemCode code) {
        super(message, cause);
        this.code = code;
    }

    public SystemCode getCode() {
        return code;
    }
}
