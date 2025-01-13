package com.fulda.webshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fulda.webshop.model.Product;

import java.util.List;

/**
 * ProductRepository is a Spring Data JPA repository interface for managing Product entities.
 * It provides methods to perform CRUD operations and custom queries on the product data.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{	
	/**
     * Fetches all products that match the specified name using a named query.
     *
     * @param name the name of the products to search for
     * @return a list of products that match the specified name
     */
    List<Product> fetchAllProductsWithName(String name); // This will use the default Spring Data JPA implementation

    /**
     * Finds products by their color.
     *
     * @param color the color to filter products by
     * @return a list of products that match the specified color
     */
    List<Product> findByColor(String color);

    /**
     * Finds products by their size.
     *
     * @param size the size to filter products by
     * @return a list of products that match the specified size
     */
    List<Product> findBySize(String size);

    /**
     * Finds products by their type.
     *
     * @param type the type to filter products by
     * @return a list of products that match the specified type
     */
    List<Product> findByType(String type);

    /**
     * Fetches all products that match the specified name with pagination support.
     *
     * @param name the name of the products to search for
     * @param pageable pagination information including page number and size
     * @return a Page containing products that match the specified name
     */
	Page<Product> fetchAllProductsWithName(String name, Pageable pageable);
}