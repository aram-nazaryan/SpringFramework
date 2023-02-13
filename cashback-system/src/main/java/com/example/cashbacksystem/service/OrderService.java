package com.example.cashbacksystem.service;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.model.PaymentRequestModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order save(PaymentRequestModel requestModel, User user);

    List<Order> getUserOrders(String uuid);

    Double getSum(String uuid);
}
