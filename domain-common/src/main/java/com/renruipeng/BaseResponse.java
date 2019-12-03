package com.renruipeng;

/**
 * @author Mr--renruipeng
 * @date 2019-11-13
 **/
public class BaseResponse<T> {

    private Integer code;

    private String msg;

    private T content;

    public BaseResponse(Integer code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public  static <T>  BaseResponse<T> success(T content) {
        return new BaseResponse<>(ReturnEnum.SUCCESS.getCode(), ReturnEnum.SUCCESS.getMsg(), content);
    }

    public static <T> BaseResponse<T> fail(){
        return new BaseResponse<>(ReturnEnum.FAIL.getCode(),ReturnEnum.FAIL.getMsg(),null);
    }

    public static <T> BaseResponse<T> fail(T content){
        return new BaseResponse<>(ReturnEnum.FAIL.getCode(),ReturnEnum.FAIL.getMsg(),content);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
