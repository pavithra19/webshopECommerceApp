package com.fulda.webshop.facade;

import com.fulda.webshop.dto.ProductDetailDTO;
import com.fulda.webshop.model.Product;
import com.fulda.webshop.service.InventoryService;
import com.fulda.webshop.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProductDetailFacade provides methods to retrieve and manipulate detailed information about products.
 * It interacts with ProductService and InventoryService to fetch data and perform operations.
 */
@Service
public class ProductDetailFacade {

	private final ProductService productService; // Service for managing products
    private final InventoryService inventoryService; // Service for checking inventory levels

    /**
     * Constructs a ProductDetailFacade with the specified services.
     *
     * @param productService service used to manage products
     * @param inventoryService service used to check product stock levels
     */
    @Autowired
    public ProductDetailFacade(ProductService productService, InventoryService inventoryService) {
        this.productService = productService;
        this.inventoryService = inventoryService;
    }

    /**
     * Retrieves all products available in the webshop.
     *
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Retrieves detailed information about a specific product by its ID.
     *
     * @param id the ID of the product to retrieve details for
     * @return a ProductDetailDTO containing detailed information about the specified product
     * @throws IllegalArgumentException if no product is found for the specified ID
     */
    public ProductDetailDTO getProductDetailById(Long id) {
    	
        Product product = productService.getProductById(id).get();
        
        if (product != null) {

            Integer stock = inventoryService.getStockForProductId(id);
            return new ProductDetailDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getSize(),
                product.getColor(),
                product.getType(),
                stock
            );
        } else {
            throw new IllegalArgumentException("Product not found for ID: " + id);
        }
    }

    /**
     * Filters products by their name.
     *
     * @param name the name to filter products by
     * @return a list of products that match the specified name
     */
    public List<Product> filterProductsByName(String name) {
        return productService.getProductsByName(name);
    }

    /**
     * Filters products by their color.
     *
     * @param color the color to filter products by
     * @return a list of products that match the specified color
     */
    public List<Product> filterProductsByColor(String color) {
        return productService.getProductsByColor(color);
    }

    /**
     * Filters products by their type.
     *
     * @param type the type to filter products by
     * @return a list of products that match the specified type
     */
    public List<Product> filterProductsByType(String type) {
        return productService.getProductsByType(type);
    }

    /**
     * Filters products by their size.
     *
     * @param size the size to filter products by
     * @return a list of products that match the specified size
     */
    public List<Product> filterProductsBySize(String size) {
        return productService.getProductsBySize(size);
    }

    /**
     * Adds a new product to the webshop.
     *
     * @param newProduct the new Product object to add 
     * @return the added Product object after saving it 
     */
    public Product addProduct(Product newProduct) {
        return productService.addProduct(newProduct);
    }

    /**
     * Deletes a specific product by its ID.
     *
     * @param id the ID of the product to delete 
     */
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
    
    /**
     * Retrieves all products with pagination support.
     *
     * @param pageable pagination information including page number and size 
     * @return a Page containing products for requested page and size 
     */
    public Page<Product> getPaginatedProducts(Pageable pageable) {
        return productService.getAllProducts(pageable); // Call paginated method from service
    }

    /**
     * Filters products by their name with pagination support.
     *
     * @param name name of products to filter 
     * @param pageable pagination information including page number and size 
     * @return a Page containing matching products for requested page and size 
     */
    public Page<Product> filterProductsByName(String name, Pageable pageable) {
        return productService.getProductsByName(name, pageable);
    }

}