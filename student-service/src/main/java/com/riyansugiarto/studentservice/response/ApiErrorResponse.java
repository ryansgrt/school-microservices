package com.riyansugiarto.studentservice.response;

public class ApiErrorResponse {
    private String message;
    private String error;

    public ApiErrorResponse(String message, String error) {
        this.message = message;
        this.error = error;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

