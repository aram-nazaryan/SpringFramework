package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.model.ErrorType;
import com.example.cashbacksystem.model.PaymentRequestModel;
import com.example.cashbacksystem.model.PaymentResponseModel;
import com.example.cashbacksystem.service.OrderService;
import com.example.cashbacksystem.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderControlFacadeImpl implements OrderControlFacade {
    private final OrderService orderService;

    private final UserService userService;

    private final OrderMapper orderMapper;

    @Override
    public PaymentResponseModel placeOrder(PaymentRequestModel model) {
        Optional<User> byUuid = userService.findByUuid(model.getUserUuid());
        ErrorType errorType = null;
        if (byUuid.isPresent()) {
            if (model.getDescription().isEmpty() ||
                    model.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                errorType = ErrorType.REQUEST_BODY_ERROR;
                return new PaymentResponseModel(errorType.errorDto());
            }
            Order savedOrder = orderService.save(model, byUuid.get());
            return orderMapper.map(savedOrder);
        } else {
            errorType = ErrorType.USER_NOT_FOUND;
            return new PaymentResponseModel(errorType.errorDto());
        }
    }
}
