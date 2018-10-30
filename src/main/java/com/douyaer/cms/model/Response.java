package com.douyaer.cms.model;

import java.util.List;

import lombok.Data;

@Data
public class Response {
    public int code;
    public String msg;
    public Object data;
    public Response (Object data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    public Response (int code) {
        this.code = code;
        this.msg = "failed";
    }
    public Response (int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response (int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response success() {
        return new OkResponse(null);
    }

    public static Response success(Object data) {
        return new OkResponse(data);
    }

    public static Response success(int total, List<?> data) {
        return new PageResponse(total, data);
    }

    public static Response error() {
        return new ErrorResponse();
    }

    public static Response error(int code) {
        return new ErrorResponse(code);
    }

    public static Response error(int code, String msg) {
        return new ErrorResponse(code, msg);
    }

    public static Response error(String msg) {
        return new ErrorResponse(-1, msg);
    }
}

class OkResponse extends Response {
    public OkResponse(Object data) {
        super(0, "success", data);
    }
}

class ErrorResponse extends Response {
    public ErrorResponse() {
        super(-1);
    }

    public ErrorResponse(int code) {
        super(code);
    }

    public ErrorResponse(int code, String msg) {
        super(code, msg);
    }
}

class PageResponse extends Response {
    private int total;
    public PageResponse(int total, List<?> data) {
        super(0, "success", data);
        this.total = total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return this.total;
    }
}