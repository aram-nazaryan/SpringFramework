package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.model.OrderResponseModel;
import com.example.cashbacksystem.model.PaymentResponseModel;
import org.aspectj.weaver.ast.Or;

public interface OrderMapper {
    PaymentResponseModel map(Order order);

    OrderResponseModel mapToResponseModel(Order order);
}
