package com.renruipeng;

public enum ReturnEnum {

    SUCCESS(1,"成功"),
    FAIL(-1,"失败");

    private Integer code;

    private String msg;

    ReturnEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
