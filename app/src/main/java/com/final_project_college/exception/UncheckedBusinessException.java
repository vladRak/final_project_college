package com.final_project_college.exception;

/**
 * The UncheckedBusinessException wraps all unchecked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class UncheckedBusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ErrorCode code;

    public UncheckedBusinessException(ErrorCode code) {
        this.code = code;
    }

    public UncheckedBusinessException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public UncheckedBusinessException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public UncheckedBusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}
