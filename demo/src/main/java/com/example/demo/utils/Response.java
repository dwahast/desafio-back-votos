package com.example.demo.utils;


public class Response {
    private final String message;
    private final Integer resultCode;

    public Response(String message, Integer resultCode) {
        this.message = message;
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
