package com.example.homework_4;

import com.example.homework_4.weather_checkers.TemperatureChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;


public class ScheduledPrinter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledPrinter.class);

    private final TemperatureChecker checker;

    public ScheduledPrinter(TemperatureChecker checker) {
        LOGGER.info("ScheduledPrinter constructor is called");
        this.checker = checker;
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void printCheckedWeather() {
        checker.checkWeather();
    }
}
