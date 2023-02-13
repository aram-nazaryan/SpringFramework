package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class OrderResponseModel {
    @JsonProperty("description")
    private String description;
    @JsonProperty("totalAmount")
    private BigDecimal amount;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
