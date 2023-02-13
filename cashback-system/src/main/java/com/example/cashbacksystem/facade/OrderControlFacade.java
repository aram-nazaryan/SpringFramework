package com.example.cashbacksystem.facade;

import com.example.cashbacksystem.model.PaymentRequestModel;
import com.example.cashbacksystem.model.PaymentResponseModel;

public interface OrderControlFacade {
    PaymentResponseModel placeOrder(PaymentRequestModel model);
}
