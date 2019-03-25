package com.final_project_college.exception;

public enum BusinessCode {

    BAD_REQUEST(400, "Client error"),
    UNAUTHORIZED(401,"Client unauthorized"),
    UNCONFIRMED_USER(1, "User must confirm email"),
    BAD_LOGIN_PASSWORD(2, "Bad combination login/password"),
    INCORRECT_INPUT(3, "Input data incorrect: ");

    private final int code;
    private final String msg;

    BusinessCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}