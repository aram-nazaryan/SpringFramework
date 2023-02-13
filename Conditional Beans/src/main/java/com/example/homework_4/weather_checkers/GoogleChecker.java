package com.example.homework_4.weather_checkers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GoogleChecker implements TemperatureChecker {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleChecker.class);

    private final int temp;

    public GoogleChecker() {
        LOGGER.info("Google constructor");
        temp = new Random().nextInt(25);
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public void checkWeather() {
        LOGGER.info("Checking weather temperature from google server...\nThe temperature is: {}C", temp);
    }
}
