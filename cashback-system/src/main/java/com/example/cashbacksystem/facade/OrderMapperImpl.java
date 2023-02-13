package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.model.OrderResponseModel;
import com.example.cashbacksystem.model.PaymentResponseModel;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper{
    @Override
    public PaymentResponseModel map(Order order) {
        PaymentResponseModel model = new PaymentResponseModel();
        model.setCreatedAt(order.getCreatedAt());
        return model;
    }

    @Override
    public OrderResponseModel mapToResponseModel(Order order) {
        OrderResponseModel model = new OrderResponseModel();
        model.setDescription(order.getDescription());
        model.setAmount(order.getPaymentAmount());
        model.setCreatedAt(order.getCreatedAt());
        return model;
    }
}
