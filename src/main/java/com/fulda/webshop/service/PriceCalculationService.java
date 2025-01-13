package com.fulda.webshop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

/**
 * PriceCalculationService provides methods for calculating and rounding prices.
 * This service ensures that prices are consistently rounded to two decimal places,
 * following the rule of rounding up from 0.5.
 */
@Service
public class PriceCalculationService {

	/**
     * Rounds the given price to two decimal places.
     *
     * @param price the price to be rounded
     * @return the rounded price as a BigDecimal
     * @throws IllegalArgumentException if the price is null
     */
    public BigDecimal roundPrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}