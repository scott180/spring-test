package com.xu.spring.test.common;

import com.xu.spring.test.common.enums.ResultEnum;
import lombok.Data;

/**
 * @author xu
 * @date 2020/1/1 12:41
 */
@Data
public class Result<T> {

    private boolean success;
    private int code;
    private T content;
    private String errorMsg;

    public Result() {
        this.setCode(ResultEnum.SUCCESS.getCode());
        this.setSuccess(true);
    }

    public static Result success() {
        return success(null);
    }

    public static <T> Result success(T t) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setSuccess(true);
        result.setContent(t);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setSuccess(false);
        resultEnum = resultEnum == null ? ResultEnum.FAIL : resultEnum;
        result.setCode(resultEnum.getCode());
        result.setErrorMsg(resultEnum.getCh());
        return result;
    }

    public void error(int failCode, String errorMsg) {
        this.setCode(failCode);
        this.setErrorMsg(errorMsg);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
