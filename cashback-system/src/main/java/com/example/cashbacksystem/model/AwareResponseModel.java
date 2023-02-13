package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AwareResponseModel {
    @JsonIgnore
    private Integer httpStatus;
    @JsonProperty("error")
    private ErrorModel error;

    public AwareResponseModel(ErrorModel error, Integer httpStatus){
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public AwareResponseModel() {
        this.httpStatus = 200;
    }

    public AwareResponseModel(ErrorModel errorModel) {
        this(errorModel, errorModel.getStatus().value());
    }
}
