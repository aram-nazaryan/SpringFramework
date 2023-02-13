package com.example.cashbacksystem.service;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.model.PaymentRequestModel;
import com.example.cashbacksystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order save(PaymentRequestModel requestModel, User user) {
        Order order = new Order();
        order.setPaymentAmount(requestModel.getAmount());
        order.setUser(user);
        order.setDescription(requestModel.getDescription());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getUserOrders(String uuid) {
        return orderRepository.findOrdersByUserUuid(uuid);
    }

    @Override
    public Double getSum(String uuid) {
        return orderRepository.getSum(uuid);
    }
}

