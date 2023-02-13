package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserDetailsResponseModel extends AwareResponseModel {
    @JsonProperty("userUuid")
    private String uuid;
    @JsonProperty("username")
    private String username;

    @JsonProperty("orders")
    List<OrderResponseModel> orders;
    @JsonProperty("cashback")
    private BigDecimal cashback;

    public UserDetailsResponseModel(ErrorModel errorModel){
        super(errorModel);
    }
}
