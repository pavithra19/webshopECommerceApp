package com.fulda.webshop.config;

import com.fulda.webshop.model.Product;
import com.fulda.webshop.repository.ProductRepository;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * LoadProductDatabase initializes the database with sample product data upon application startup.
 */
@Configuration
public class LoadProductDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadProductDatabase.class);

    /**
     * Initializes the database with hardcoded products when the application starts.
     *
     * @param productRepository repository used to save products to the database
     * @return CommandLineRunner that preloads sample data into the database
     */
    @Bean
    public CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            // Hardcoded products to initialize
            Product product1 = new Product();
            product1.setName("H&M tee");
            product1.setType("T-Shirt");
            product1.setPrice(new BigDecimal("19.99"));
            product1.setSize("M");
            product1.setColor("Red");

            Product product2 = new Product();
            product2.setName("Levis jeans");
            product2.setType("Jeans");
            product2.setPrice(new BigDecimal("49.99"));
            product2.setSize("L");
            product2.setColor("Blue");

            Product product3 = new Product();
            product3.setName("Addidas sneaker");
            product3.setType("Sneakers");
            product3.setPrice(new BigDecimal("79.99"));
            product3.setSize("10");
            product3.setColor("White");

            Product product4 = new Product();
            product4.setName("H&M jacket");
            product4.setType("Jacket");
            product4.setPrice(new BigDecimal("89.99"));
            product4.setSize("M");
            product4.setColor("Black");

            Product product5 = new Product();
            product5.setName("Nike hat");
            product5.setType("Hat");
            product5.setPrice(new BigDecimal("15.99"));
            product5.setSize("One Size");
            product5.setColor("Green");

            Product product6 = new Product();
            product6.setName("C&A sweater");
            product6.setType("Sweater");
            product6.setPrice(new BigDecimal("39.99"));
            product6.setSize("L");
            product6.setColor("Gray");

            Product product7 = new Product();
            product7.setName("C&A shorts navy");
            product7.setType("Shorts");
            product7.setPrice(new BigDecimal("29.99"));
            product7.setSize("M");
            product7.setColor("Navy");

            Product product8 = new Product();
            product8.setName("Adidas socks");
            product8.setType("Socks");
            product8.setPrice(new BigDecimal("9.99"));
            product8.setSize("One Size");
            product8.setColor("Black");

            Product product9 = new Product();
            product9.setName("C&A belt");
            product9.setType("Belt");
            product9.setPrice(new BigDecimal("24.99"));
            product9.setSize("M");
            product9.setColor("Brown");

            Product product10 = new Product();
            product10.setName("C&A scarf");
            product10.setType("Scarf");
            product10.setPrice(new BigDecimal("19.99"));
            product10.setSize("One Size");
            product10.setColor("Red");

            // Save products to the database
            logger.info("Preloading " + productRepository.save(product1));
            logger.info("Preloading " + productRepository.save(product2));
            logger.info("Preloading " + productRepository.save(product3));
            logger.info("Preloading " + productRepository.save(product4));
            logger.info("Preloading " + productRepository.save(product5));
            logger.info("Preloading " + productRepository.save(product6));
            logger.info("Preloading " + productRepository.save(product7));
            logger.info("Preloading " + productRepository.save(product8));
            logger.info("Preloading " + productRepository.save(product9));
            logger.info("Preloading " + productRepository.save(product10));
        };
    }
}