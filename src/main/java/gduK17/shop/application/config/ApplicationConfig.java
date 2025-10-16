package gduK17.shop.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the application layer.
 * Sets up component scanning for services and DTOs.
 */
@Configuration
@ComponentScan(basePackages = { "gduK17.shop.application.service", "gduK17.shop.application.dto" })
public class ApplicationConfig {
    // Additional application layer configuration can go here
}