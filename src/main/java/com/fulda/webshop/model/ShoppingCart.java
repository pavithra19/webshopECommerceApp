package com.fulda.webshop.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fulda.webshop.service.PriceCalculationService;

/**
 * ShoppingCart represents a user's shopping cart containing selected products.
 * It provides functionality to calculate total prices and manage items in the cart.
 */
public class ShoppingCart
{
    public Map<Product, Integer> products; // Map holding products and their quantities in the cart
    private final PriceCalculationService priceCalculationService; // Service for price calculations

    /**
     * Constructs a ShoppingCart with specified products and price calculation service.
     *
     * @param products map of products and their quantities in this cart 
     * @param priceCalculationService service used for price calculations 
     */
    public ShoppingCart(Map<Product, Integer> products, PriceCalculationService priceCalculationService) {
        this.products = products;
        this.priceCalculationService = priceCalculationService;
    }
    
    /**
     * Calculates the total price of items in this shopping cart, rounding it to two decimal places.
     *
     * @return total price as a BigDecimal rounded to two decimal places 
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return priceCalculationService.roundPrice(totalPrice); // Round total price using PriceCalculation service 
    }
}