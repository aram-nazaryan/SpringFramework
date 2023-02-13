package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@ToString
public class PaymentResponseModel extends AwareResponseModel{
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    public PaymentResponseModel(ErrorModel errorModel){
        super(errorModel);
    }
}
