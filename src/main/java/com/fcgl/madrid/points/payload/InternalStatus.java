package com.fcgl.madrid.points.payload;

import java.util.List;
import java.util.ArrayList;

public class InternalStatus {
    public static final InternalStatus OK = new InternalStatus(StatusCode.OK, 200, "ok");
    public static final InternalStatus MISSING_PARAM = new InternalStatus(StatusCode.PARAM, 400, "Missing Required Param");

    private int code;
    private int httpCode;
    private List<String> messages;

    public InternalStatus() {

    }

    public InternalStatus(StatusCode statusCode, int httpCode, String message) {
        this.code = statusCode.getCode();
        this.httpCode = httpCode;
        this.messages = new ArrayList<String>();
        this.messages.add(message);
    }

    public InternalStatus(StatusCode statusCode, int httpCode, List<String> messages) {
        this.code = statusCode.getCode();
        this.httpCode = httpCode;
        this.messages = messages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
