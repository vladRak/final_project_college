package com.final_project_college.exception;

public enum DataAccessCode {

    TRANSACTION_EXCEPTION(1, "Transaction manager exception"),
    SQL_EXCEPTION(2, "Some SQL exception"),
    EXTERNAL_CONFIG_EXCEPTION(3, "Problem with external config"),
    INTERNAL_EXCEPTION(500, "Internal exception");

    private final int code;
    private final String msg;

    DataAccessCode(int code, String msg) {
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
