package com.final_project_college.exception;

/**
 * The SystemException wraps all checked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class SystemException extends Exception {

    private static final long serialVersionUID = 1L;

    private final SystemCode code;

    public SystemException(SystemCode code) {
        this.code = code;
    }

    public SystemException(String message, SystemCode code) {
        super(message);
        this.code = code;
    }

    public SystemException(Throwable cause, SystemCode code) {
        super(cause);
        this.code = code;
    }

    public SystemException(String message, Throwable cause, SystemCode code) {
        super(message, cause);
        this.code = code;
    }

    public SystemCode getCode() {
        return code;
    }
}
