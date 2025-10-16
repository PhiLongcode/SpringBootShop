package gduK17.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application class for the Shop application.
 * Uses Clean Architecture principles with layers:
 * - Domain: Core business logic
 * - Application: Use cases orchestration
 * - Infrastructure: External concerns (database, file system)
 * - Presentation: UI/Controllers
 */
@SpringBootApplication
@ComponentScan(basePackages = {
		"gduK17.shop.domain",
		"gduK17.shop.application",
		"gduK17.shop.infrastructure",
		"gduK17.shop.presentation"
})
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
