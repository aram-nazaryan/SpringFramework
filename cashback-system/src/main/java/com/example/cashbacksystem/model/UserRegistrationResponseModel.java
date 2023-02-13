package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@ToString
public class UserRegistrationResponseModel extends AwareResponseModel {
    @JsonProperty("username")
    private String username;
    @JsonProperty("registeredAt")
    private LocalDateTime registeredAt;
    @JsonProperty("uuid")
    private String uuid;

    public UserRegistrationResponseModel(final ErrorModel errorModel){
        super(errorModel);
    }
}
