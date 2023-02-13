package com.example.cashbacksystem.service;

import com.example.cashbacksystem.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> register (UserRegistrationCreateParams params);

    Boolean isRegistered (String username);

    Optional<User> findByUuid(String uuid);

}
