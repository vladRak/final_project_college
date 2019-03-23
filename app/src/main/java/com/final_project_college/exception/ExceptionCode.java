package com.final_project_college.exception;

public enum ExceptionCode {

    SQL_EXCEPTION(1, "Some SQL exception"),
    TRANSACTION_EXCEPTION(2, "Transaction manager exception"),
    INTERNAL_EXCEPTION(500, "Internal exception");

    private final int code;
    private final String msg;

    ExceptionCode(int code, String msg){
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
