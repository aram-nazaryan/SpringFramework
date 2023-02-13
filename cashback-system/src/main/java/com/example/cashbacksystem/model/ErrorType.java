package com.example.cashbacksystem.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    USER_ALREADY_REGISTERED("user_already_registered", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_NOT_FOUND("user_not_found", HttpStatus.NOT_FOUND),
    REQUEST_BODY_ERROR("request_body_error", HttpStatus.BAD_REQUEST);

    private final String id;
    private final HttpStatus httpStatus;

    ErrorType(String id, final HttpStatus httpStatus) {
        this.id = id;
        this.httpStatus = httpStatus;
    }

    public ErrorModel errorDto() {
        return new ErrorModel(getId(), name(), getHttpStatus());
    }

}