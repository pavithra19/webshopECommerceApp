package com.fulda.webshop.service;

import com.fulda.webshop.model.Product;
import com.fulda.webshop.model.ShoppingCart;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ShoppingCartService manages the shopping cart operations, including adding products,
* retrieving the current cart, and calculating total prices.
*/
@Service
public class ShoppingCartService
{
    private final ShoppingCart shoppingCart; // Holds the current shopping cart state
    private final InventoryService inventoryService; // Service for managing product inventory

    /**
     * Constructs a ShoppingCartService with the specified InventoryService.
     *
     * @param inventoryService the service used to manage product stock
     * @param priceCalculationService the service used to manage price calculation
     */
    @Autowired
    public ShoppingCartService(InventoryService inventoryService, PriceCalculationService priceCalculationService) {
        this.inventoryService = inventoryService;
        this.shoppingCart = new ShoppingCart(new HashMap<>(), priceCalculationService);
    }

    /**
     * Adds a product to the shopping cart if there is enough stock available.
     *
     * @param product the product to add to the cart
     * @return null if successful, or an error message if not enough stock is available
     */
    public String addProduct(Product product) {
        if (inventoryService.reduceStockForProductId(product.getId())) { // Reduce stock before adding to cart
        	
        	int currentQuantity = shoppingCart.products.getOrDefault(product, 0);
            
            shoppingCart.products.put(product, currentQuantity + 1);
            
            return null;
        } else {
        	return "Not enough stock for product: " + product.getName(); // Return error message
        }   
    }

    /**
     * Retrieves the current shopping cart.
     *
     * @return the current shopping cart instance
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}