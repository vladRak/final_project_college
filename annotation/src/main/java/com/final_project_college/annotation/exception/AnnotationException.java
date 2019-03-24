package com.final_project_college.annotation.exception;

/**
 * The AnnotationException throws in runtime with a custom error code.
 *
 * @author vladRak
 */
public class AnnotationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private AnnotationExceptionCode code;

    public AnnotationException(AnnotationExceptionCode code) {
        this.code = code;
    }

    public AnnotationException(String message, AnnotationExceptionCode code) {
        super(message);
        this.code = code;
    }

    public AnnotationException(Throwable cause, AnnotationExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public AnnotationException(String message, Throwable cause, AnnotationExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public AnnotationExceptionCode getCode() {
        return code;
    }

}
