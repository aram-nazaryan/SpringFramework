package com.example.cashbacksystem.controller;

import com.example.cashbacksystem.facade.OrderControlFacade;
import com.example.cashbacksystem.model.PaymentRequestModel;
import com.example.cashbacksystem.model.PaymentResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final OrderControlFacade orderControlFacade;

    @PostMapping
    public ResponseEntity<PaymentResponseModel> addPayment(@RequestBody PaymentRequestModel requestModel) {
        log.info("Post request(payments) with body - {}", requestModel);
        PaymentResponseModel paymentResponseModel = orderControlFacade.placeOrder(requestModel);
        return ResponseEntity.status(paymentResponseModel.getHttpStatus()).body(paymentResponseModel);
    }
}
