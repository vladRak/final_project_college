package com.final_project_college.exception;

/**
 * The BusinessException wraps all checked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ErrorCode code;

    public BusinessException(ErrorCode code) {
        this.code = code;
    }

    public BusinessException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}
