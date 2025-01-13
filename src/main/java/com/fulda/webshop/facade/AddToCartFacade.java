package com.fulda.webshop.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulda.webshop.model.Product;
import com.fulda.webshop.model.ShoppingCart;
import com.fulda.webshop.service.InventoryService;
import com.fulda.webshop.service.ProductService;
import com.fulda.webshop.service.ShoppingCartService;

/**
* AddToCartFacade is responsible for managing the process of adding products to the shopping cart.
* It checks inventory levels and interacts with the ShoppingCartService to update the cart.
*/
@Service
public class AddToCartFacade {

    private final ShoppingCartService shoppingCartService; // Service for managing shopping cart operations
    private final InventoryService inventoryService; // Service for managing product inventory
    private final ProductService productService; // Service for managing product data

    /**
     * Constructs an AddToCartFacade with the specified services.
     *
     * @param shoppingCartService service used to manage shopping cart operations
     * @param inventoryService service used to check product stock levels
     * @param productService service used to fetch product details
     */
    @Autowired
    public AddToCartFacade(ShoppingCartService shoppingCartService, InventoryService inventoryService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.inventoryService = inventoryService;
        this.productService = productService;
    }

    /**
     * Adds a product to the shopping cart based on its ID.
     *
     * @param productId the ID of the product to add to the cart
     * @return the updated ShoppingCart after adding the product
     * @throws IllegalStateException if there is not enough stock available for the product
     */
    public ShoppingCart addToCart(Long productId) {
    	
    	Product product = productService.getProductById(productId).get(); // Fetch product details from ProductService
    	
        // Check stock before adding to cart
        if (inventoryService.getStockForProductId(productId) > 0) {
            shoppingCartService.addProduct(product); // Add product to cart
            return shoppingCartService.getShoppingCart(); // Return updated cart
        } else {
            throw new IllegalStateException("Not enough stock for product: " + product.getName());
        }
    }
}
