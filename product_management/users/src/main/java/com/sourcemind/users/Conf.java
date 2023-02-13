package com.sourcemind.users;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(DataSourceConfigurationProperties.class)
public class Conf {

    @Bean
    @ConditionalOnProperty(name = "auth.username.prefix")
    public ImMemoryUsers properties(DataSourceConfigurationProperties properties) {
        ImMemoryUsers imMemoryUsers = new ImMemoryUsers(properties);
        imMemoryUsers.addUsers();
        return imMemoryUsers;
    }

}
