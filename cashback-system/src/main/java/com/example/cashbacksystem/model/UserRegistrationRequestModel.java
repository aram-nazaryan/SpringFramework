package com.example.cashbacksystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRegistrationRequestModel {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}
