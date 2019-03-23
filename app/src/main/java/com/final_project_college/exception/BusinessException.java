package com.final_project_college.exception;

/**
 * The BusinessException wraps all checked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ExceptionCode code;

    public BusinessException(ExceptionCode code) {
        this.code = code;
    }

    public BusinessException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause, ExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, ExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
