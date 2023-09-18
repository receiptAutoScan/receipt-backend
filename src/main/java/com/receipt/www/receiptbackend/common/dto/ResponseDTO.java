package com.receipt.www.receiptbackend.common.dto;

import org.springframework.http.HttpStatus;

public class ResponseDTO {

    private int status;
    private String message;
    private Object result;

    public ResponseDTO(HttpStatus status, String message, Object result) {
        this.status = status.value();
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
