package com.zwj.book.base;


import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;


/**
 * StatusMessage 定义了返回给前端的消息体结构（JSON 格式）
 */
public class ResultBody {
    public static final int OK_STATUS_CODE = 0;
    public static final String OK_MESSAGE = "OK";
    public static final Map<String, String> EMPTY_DATA = new HashMap<>();


    public static final ResultBody DEFAULT_OK_MESSAGE =
            new ResultBody(OK_STATUS_CODE, OK_MESSAGE, EMPTY_DATA);

    private int code; // 状态码
    private Object message; // 消息描述
    private Object data; // 携带的数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultBody() {
        this.message = "";
        this.data = EMPTY_DATA;
    }

    public ResultBody(int code, Object message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String toJSON() {
        return JSON.toJSONString(this);
    }

    public ResultBody withCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBody withMessage(Object message) {
        this.message = message;
        return this;
    }

    public ResultBody withData(Object data) {
        this.data = data;
        return this;
    }
}
