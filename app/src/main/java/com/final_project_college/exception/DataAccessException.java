package com.final_project_college.exception;

/**
 * The DataAccessException wraps all checked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class DataAccessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final DataAccessCode code;

    public DataAccessException(DataAccessCode code) {
        this.code = code;
    }

    public DataAccessException(String message, DataAccessCode code) {
        super(message);
        this.code = code;
    }

    public DataAccessException(Throwable cause, DataAccessCode code) {
        super(cause);
        this.code = code;
    }

    public DataAccessException(String message, Throwable cause, DataAccessCode code) {
        super(message, cause);
        this.code = code;
    }

    public DataAccessCode getCode() {
        return code;
    }
}
