package com.example.homework_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableConfigurationProperties(ConfProperties.class)
@EnableScheduling
public class Conf {
    private static final Logger LOGGER = LoggerFactory.getLogger(Conf.class);

    @Bean
    @ConditionalOnProperty(name = "weather.server")
    public ScheduledPrinter scheduledPrinter(ConfProperties properties) {
        LOGGER.info("Conf (scheduledPrinter) with properties - {}", properties);
        return new ScheduledPrinter(properties.getChecker());
    }
}
