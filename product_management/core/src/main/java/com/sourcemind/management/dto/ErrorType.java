package com.sourcemind.management.dto;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    IMAGE_NOT_FOUND("image_not_found", HttpStatus.NOT_FOUND),
    PRODUCT_NOT_FOUND("not_found", HttpStatus.BAD_REQUEST);

    private final String id;
    private final HttpStatus httpStatus;

    ErrorType(String id, final HttpStatus httpStatus) {
        this.id = id;
        this.httpStatus = httpStatus;
    }

    public ErrorModel errorDto() {
        return new ErrorModel(getId(), name(), getHttpStatus());
    }

    public String getId() {
        return id;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}