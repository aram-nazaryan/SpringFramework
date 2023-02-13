package com.sourcemind.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;


public class ErrorModel {
    private String id;
    private String message;

    @JsonIgnore
    private HttpStatus status;

    public ErrorModel() {
    }

    public ErrorModel(String id, String message, HttpStatus status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
