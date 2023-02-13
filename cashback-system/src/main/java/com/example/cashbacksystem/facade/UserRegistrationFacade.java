package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.model.UserDetailsResponseModel;
import com.example.cashbacksystem.model.UserRegistrationRequestModel;
import com.example.cashbacksystem.model.UserRegistrationResponseModel;

public interface UserRegistrationFacade {
    UserRegistrationResponseModel registration(UserRegistrationRequestModel requestModel);

    Boolean isUserRegistered(UserRegistrationRequestModel requestModel);

    UserDetailsResponseModel getUserDetails(String uuid);
}
