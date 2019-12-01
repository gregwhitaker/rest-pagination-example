package example.employee.controller.config;

import example.employee.controller.config.settings.DatabaseSettings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({
        DatabaseSettings.class
})
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource(DatabaseSettings settings) {
        return null;
    }
}
