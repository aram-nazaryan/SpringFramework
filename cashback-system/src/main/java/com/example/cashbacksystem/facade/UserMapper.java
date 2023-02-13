package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.model.UserRegistrationResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper
public interface UserMapper {
    UserRegistrationResponseModel map(User user);
}
