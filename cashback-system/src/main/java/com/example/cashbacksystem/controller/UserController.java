package com.example.cashbacksystem.controller;

import com.example.cashbacksystem.facade.UserRegistrationFacade;
import com.example.cashbacksystem.model.UserDetailsResponseModel;
import com.example.cashbacksystem.model.UserRegistrationRequestModel;
import com.example.cashbacksystem.model.UserRegistrationResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserRegistrationFacade userRegistrationFacade;

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDetailsResponseModel> send(@PathVariable("uuid") String uuid) {
        log.info("Get request(users) with param - {}", uuid);

        UserDetailsResponseModel model = userRegistrationFacade.getUserDetails(uuid);

        return ResponseEntity.status(model.getHttpStatus()).body(model);
    }

    @PostMapping
    public ResponseEntity<UserRegistrationResponseModel> register(@RequestBody UserRegistrationRequestModel requestModel) {
        log.info("Post request(users) with body - {}", requestModel);

        UserRegistrationResponseModel registrationResponse = userRegistrationFacade.registration(requestModel);

        log.info("Post request(users) response body - {}", registrationResponse);
        return ResponseEntity.status(registrationResponse.getHttpStatus()).body(registrationResponse);
    }
}
