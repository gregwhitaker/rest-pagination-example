package example.employee.controller.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import example.employee.controller.config.settings.DatabaseSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({
        DatabaseSettings.class
})
public class DatabaseConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean
    public DataSource dataSource(DatabaseSettings settings) {
        if (StringUtils.isEmpty(settings.getJdbcUrl())) {
            throw new IllegalStateException("Database configuration not found! Please verify that you have specified a database configuration for the current environment.");
        }

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(settings.getJdbcUrl());
        hikariConfig.setUsername(settings.getUsername());

        if (settings.getPassword() != null) {
            hikariConfig.setPassword(settings.getPassword());
        }

        if (settings.getMaxPoolSize() != null) {
            hikariConfig.setMaximumPoolSize(settings.getMaxPoolSize());
        }

        LOG.info("Configuring Database Connection: {}", hikariConfig.getJdbcUrl());

        return new HikariDataSource(hikariConfig);
    }
}
