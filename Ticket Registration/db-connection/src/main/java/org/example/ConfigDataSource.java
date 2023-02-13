package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConfigDataSource extends HikariDataSource {
    private static final HikariConfig config = new HikariConfig();

    public static HikariDataSource getDataSourceInstance() {
        config.setJdbcUrl("jdbc:postgresql://0.0.0.0:5441/admin");
        config.setUsername("admin");
        config.setPassword("admin");
        return new HikariDataSource(config);
    }

}
