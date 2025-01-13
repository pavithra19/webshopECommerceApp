package com.fulda.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fulda.webshop.model.Product;
import com.fulda.webshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ProductService provides methods to manage products in the webshop.
 * It interacts with the database through the ProductRepository to perform CRUD operations.
 */
@Service
public class ProductService
{
	private final ProductRepository productRepository; // Repository for accessing product data

	/**
     * Constructs a ProductService with the specified ProductRepository.
     *
     * @param productRepository the repository used for managing product data
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves all products from the database.
     *
     * @return a list of all products available in the webshop
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Fetch all products from the database
    }
    
    /**
     * Retrieves a specific product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return an Optional containing the found product or empty if not found
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id); // Fetch product by ID from the database
    }

    /**
     * Retrieves all products that match a specified color.
     *
     * @param color the color to filter products by
     * @return a list of products that match the specified color
     */
    public List<Product> getProductsByColor(String color) {
        return productRepository.findByColor(color); // Fetch products by color
    }

    /**
     * Retrieves all products that match a specified size.
     *
     * @param size the size to filter products by
     * @return a list of products that match the specified size
     */
    public List<Product> getProductsBySize(String size) {
        return productRepository.findBySize(size); // Fetch products by size
    }

    /**
     * Retrieves all products that match a specified type.
     *
     * @param type the type to filter products by
     * @return a list of products that match the specified type
     */
    public List<Product> getProductsByType(String type) {
        return productRepository.findByType(type); // Fetch products by type
    }

    /**
     * Adds a new product to the database.
     *
     * @param newProduct the new product to add
     * @return the saved product instance after persisting it to the database
     */
    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct); // Save new product to database
    }
    
    /**
     * Retrieves all products that match a specified name.
     *
     * @param name the name to filter products by
     * @return a list of products that match the specified name
     */
    public List<Product> getProductsByName(String name) {
        return productRepository.fetchAllProductsWithName(name); // Use repository method to fetch by name
    }
    
    /**
     * Deletes a specific product by its ID.
     *
     * @param id the ID of the product to delete
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id); // Delete a product by its ID
    }
    
    /**
     * Retrieves all products with pagination support.
     *
     * @param pageable pagination information including page number and size
     * @return a Page containing products for the requested page and size 
     */
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    /**
     * Retrieves all products matching a specified name with pagination support.
     *
     * @param name   the name to filter products by 
     * @param pageable pagination information including page number and size 
     * @return a Page containing matching products for requested page and size 
     */
    public Page<Product> getProductsByName(String name, Pageable pageable) {
        return productRepository.fetchAllProductsWithName(name, pageable);
    }
}