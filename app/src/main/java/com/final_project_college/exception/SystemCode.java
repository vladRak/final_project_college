package com.final_project_college.exception;

public enum SystemCode {

    SQL_EXCEPTION(1, "Some SQL exception"),
    TRANSACTION_EXCEPTION(2, "Transaction manager exception"),
    EXTERNAL_CONFIG_EXCEPTION(3, "Problem with external config"),
    INTERNAL_EXCEPTION(500, "Internal exception");

    private final int code;
    private final String msg;

    SystemCode(int code, String msg) {
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
