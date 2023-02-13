package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.model.UserRegistrationRequestModel;
import com.example.cashbacksystem.model.UserRegistrationResponseModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRegistrationResponseModel map(User user) {
        UserRegistrationResponseModel model = new UserRegistrationResponseModel();
        model.setUuid(user.getUuid());
        model.setRegisteredAt(user.getRegisteredAt());
        model.setUuid(user.getUuid());
        return model;
    }
}
