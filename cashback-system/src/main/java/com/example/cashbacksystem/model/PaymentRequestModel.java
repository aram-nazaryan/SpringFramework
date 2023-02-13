package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaymentRequestModel {
    @JsonProperty("userUuid")
    private String userUuid;
    @JsonProperty("totalAmount")
    private BigDecimal amount;
    @JsonProperty("description")
    private String description;
}
