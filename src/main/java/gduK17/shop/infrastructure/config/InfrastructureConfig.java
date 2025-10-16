package gduK17.shop.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for the infrastructure layer.
 * Enables JPA repositories and transaction management.
 */
@Configuration
@EnableJpaRepositories(basePackages = "gduK17.shop.infrastructure.persistence.repository")
@EnableTransactionManagement
public class InfrastructureConfig {
    // Additional infrastructure configuration can go here
}