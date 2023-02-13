package com.example.cashbacksystem.service;

import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> register(UserRegistrationCreateParams params) {
        log.info("Registering user with params - {}", params);
        User user = new User();
        user.setUsername(params.username());
        user.setPassword(params.password());
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public Boolean isRegistered(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.isPresent();
    }

    @Override
    public Optional<User> findByUuid(String uuid) {
        Optional<User> usersByUuid = userRepository.findUsersByUuid(uuid);
        return usersByUuid;
    }
}
