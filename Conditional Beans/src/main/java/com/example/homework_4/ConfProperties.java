package com.example.homework_4;

import com.example.homework_4.weather_checkers.AmazonChecker;
import com.example.homework_4.weather_checkers.GoogleChecker;
import com.example.homework_4.weather_checkers.TemperatureChecker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "weather")
public class ConfProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfProperties.class);
    private TemperatureChecker checker;
    private String server;

    @PostConstruct
    void init() throws Exception {
        LOGGER.info("Init begins server is {}", server);
        if (server.equalsIgnoreCase("amazon"))
            checker = new AmazonChecker();
        else if (server.equalsIgnoreCase("google"))
            checker = new GoogleChecker();
        else
            throw new Exception("Invalid Server");
        LOGGER.info("Init ends checker is {}", checker.toString());
    }

    public ConfProperties() {
        LOGGER.info("Conf properties are constructed");
    }

    public void setChecker(TemperatureChecker checker) {
        this.checker = checker;
    }

    public TemperatureChecker getChecker() {
        return checker;
    }

    public void setServer(String server) {
        LOGGER.info("Server is {}", server);
        this.server = server;
    }
}
