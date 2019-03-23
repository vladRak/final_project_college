package com.final_project_college.exception;

/**
 * The UncheckedBusinessException wraps all unchecked standard Java exception
 * and enriches them with a custom error code.
 *
 * @author vladRak
 */
public class UncheckedBusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ExceptionCode code;

    public UncheckedBusinessException(ExceptionCode code) {
        this.code = code;
    }

    public UncheckedBusinessException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }

    public UncheckedBusinessException(Throwable cause, ExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public UncheckedBusinessException(String message, Throwable cause, ExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
