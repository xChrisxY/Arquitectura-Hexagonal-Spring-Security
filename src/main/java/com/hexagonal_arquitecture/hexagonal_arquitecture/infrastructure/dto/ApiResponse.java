package com.hexagonal_arquitecture.hexagonal_arquitecture.infrastructure.dto;

public class ApiResponse<T> {

    private boolean success;
    private String message;
    private int status;
    private T data;

    public ApiResponse(String message, T data) {
        this.success = true;
        this.message = message;
        this.status = 200;
        this.data = data;
    }



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
