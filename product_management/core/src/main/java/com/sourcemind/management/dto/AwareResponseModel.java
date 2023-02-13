package com.sourcemind.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AwareResponseModel {
    @JsonIgnore
    private Integer httpStatus;
    @JsonProperty("error")
    private ErrorModel error;

    public AwareResponseModel(ErrorModel error, Integer httpStatus) {
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public AwareResponseModel() {
        this.httpStatus = 200;
    }

    public AwareResponseModel(ErrorModel errorModel) {
        this(errorModel, errorModel.getStatus().value());
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }
}
