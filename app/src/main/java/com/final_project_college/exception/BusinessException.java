package com.final_project_college.exception;

/**
 * The BusinessException wraps all unchecked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final BusinessCode code;

    public BusinessException(BusinessCode code) {
        this.code = code;
    }

    public BusinessException(String message, BusinessCode code) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause, BusinessCode code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, BusinessCode code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessCode getCode() {
        return code;
    }
}
