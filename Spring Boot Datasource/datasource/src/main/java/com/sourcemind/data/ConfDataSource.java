package com.sourcemind.data;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;
@ComponentScan("com.sourcemind")
@EnableConfigurationProperties(DataSourceConfigurationProperties.class)
public class ConfDataSource {

    @Bean
    @ConditionalOnProperty(name = {"url", "username", "password"})
    public JDBConnection jdbConnection(DataSourceConfigurationProperties properties) throws SQLException {
        return new JDBConnection(properties);
    }
}


