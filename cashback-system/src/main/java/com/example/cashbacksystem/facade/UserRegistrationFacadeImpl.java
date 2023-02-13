package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.model.*;
import com.example.cashbacksystem.service.OrderService;
import com.example.cashbacksystem.service.UserRegistrationCreateParams;
import com.example.cashbacksystem.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Component
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationFacadeImpl implements UserRegistrationFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @Override
    public UserRegistrationResponseModel registration(UserRegistrationRequestModel requestModel) {
        log.info("UserRegistrationFacadeImpl is working with registration with params - {}", requestModel);
        if (isUserRegistered(requestModel)) {
            ErrorType userAlreadyRegistered = ErrorType.USER_ALREADY_REGISTERED;
            log.info("User already registered");
            return new UserRegistrationResponseModel(userAlreadyRegistered.errorDto());
        }

        Optional<User> registeredUser = userService.register(new UserRegistrationCreateParams(requestModel.getUsername(), requestModel.getPassword()));
        UserRegistrationResponseModel responseModel = null;
        if (registeredUser.isPresent()) {
            responseModel = userMapper.map(registeredUser.get());
        }
        return responseModel;
    }

    @Override
    public Boolean isUserRegistered(UserRegistrationRequestModel requestModel) {
        return userService.isRegistered(requestModel.getUsername());
    }

    @Override
    public UserDetailsResponseModel getUserDetails(String uuid) {
        ErrorType errorType = null;
        Optional<User> byUuid = userService.findByUuid(uuid);
        if (byUuid.isEmpty()) {
            errorType = ErrorType.USER_NOT_FOUND;
            return new UserDetailsResponseModel(errorType.errorDto());
        }
        User user = byUuid.get();
        List<Order> userOrders = orderService.getUserOrders(uuid);
        List<OrderResponseModel> mappedOrders = userOrders.stream()
                .map(orderMapper::mapToResponseModel)
                .collect(Collectors.toList());
        BigDecimal amount = BigDecimal.valueOf(orderService.getSum(uuid) * 5 / 100);
        return new UserDetailsResponseModel(uuid, user.getUsername(), mappedOrders, amount);
    }
}
