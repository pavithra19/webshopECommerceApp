package com.fulda.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application is the main entry point for the Spring Boot application.
 * It initializes and runs the application context.
 */
@SpringBootApplication()
public class Application {

	/**
     * The main method that serves as the entry point for the Spring Boot application.
     *
     * @param args command-line arguments passed during application startup
     */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); // Launches the Spring Boot application
	}

}
