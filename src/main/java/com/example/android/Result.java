package com.example.android;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.criteria.CriteriaBuilder;

@ControllerAdvice
public class Result<T>{
    private Integer code;

    private String msg;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return  result;
    }

    public Result error(Integer code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
