package com.fulda.webshop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * InventoryService manages the stock levels of products in the webshop.
 * It provides functionality to check and update the stock for specific products.
 */
@Service
public class InventoryService
{
    // HashMap to hold productId and stock count
    private final Map<Long, Integer> inventory = new HashMap<>();

    /**
     * Initializes the inventory with predefined stock levels for demonstration purposes.
     */
    public InventoryService() {
        // Example product IDs with their initial stock counts
        inventory.put(1L, 1); // Product ID 1 has 1 unit in stock
        inventory.put(2L, 5);  // Product ID 2 has 5 units in stock
        inventory.put(3L, 0);  // Product ID 3 is sold out
        inventory.put(4L, 20); // Product ID 4 has 20 units in stock
        inventory.put(5L, 15); // Product ID 5 has 15 units in stock
        inventory.put(6L, 2); // Product ID 6 has 2 units in stock
        inventory.put(7L, 19); // Product ID 7 has 19 units in stock
        inventory.put(8L, 1); // Product ID 8 has 1 units in stock
        inventory.put(9L, 2); // Product ID 9 has 2 units in stock
        inventory.put(10L, 3); // Product ID 10 has 3 units in stock
    }

    /**
     * Retrieves the current stock level for a specific product by its ID.
     *
     * @param productId the ID of the product to check stock for
     * @return the current stock count for the specified product; returns 0 if not found
     */
    public int getStockForProductId(Long productId) {
        return inventory.getOrDefault(productId, 0);
    }

    /**
     * Reduces the stock level for a specific product by its ID if there is sufficient stock.
     *
     * @param productId the ID of the product to reduce stock for
     * @return true if the stock was successfully reduced; false if not enough stock is available
     */
    public boolean reduceStockForProductId(Long productId) {
        int currentStock = getStockForProductId(productId);
        
        if (currentStock > 0)
        {
            inventory.put(productId, currentStock - 1);
            return true; // Stock reduced successfully
        }
        
        
        return false; // Not enough stock to reduce
    }
}
