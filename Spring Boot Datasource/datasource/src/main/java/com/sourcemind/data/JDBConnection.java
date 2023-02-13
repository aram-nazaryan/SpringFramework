package com.sourcemind.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBConnection {
    private final Connection connection;


    public JDBConnection(final DataSourceConfigurationProperties properties) throws SQLException {
        this.connection = DriverManager.getConnection(properties.getUrl(), properties.getUsername(), properties.getPassword());
    }

    public Connection getConnection() {
        return connection;
    }
}
