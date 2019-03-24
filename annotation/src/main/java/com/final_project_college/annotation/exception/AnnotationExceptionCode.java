package com.final_project_college.annotation.exception;

public enum AnnotationExceptionCode {

    WEB_CONTROLLER_EXCEPTION(1, "Web controller exception message"),
    CREDENTIALS_EXCEPTION(2, "Credentials exception message");

    private final int code;
    private final String msg;

    AnnotationExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getExceptionCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}