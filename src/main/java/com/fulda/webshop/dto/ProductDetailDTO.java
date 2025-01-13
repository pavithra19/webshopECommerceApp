package com.fulda.webshop.dto;

import java.math.BigDecimal;

/**
 * ProductDetailDTO is a Data Transfer Object (DTO) representing detailed information about a product.
 * It is used to transfer product data between different layers of the application.
 */
public class ProductDetailDTO {
    private Long id; // Product ID
    private String name; // Product name
    private BigDecimal price; // Product price
    private String size; // Product size
    private String color; // Product color
    private String type; // Product Type
    private Integer stock; // Stock count
    private boolean isSoldOut; // Indicator if the product is sold out

    /**
     * Constructs a ProductDetailDTO with specified attributes.
     *
     * @param id unique identifier of the product
     * @param name name of the product
     * @param price price of the product
     * @param size size of the product
     * @param color color of the product
     * @param type type/category of the product
     * @param stock current stock count of the product
     */
    public ProductDetailDTO(Long id, String name, BigDecimal price, String size, String color, String type, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.type = type;
        this.stock = stock;
        this.isSoldOut = (stock == 0); // Determine if sold out based on stock count
    }

    /**
     * Retrieves the unique identifier of the product.
     *
     * @return the ID of the product
     */
    public Long getId() {
        return id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return the price of the product as a BigDecimal
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Retrieves the size of the product.
     *
     * @return the size of the product
     */
    public String getSize() {
        return size;
    }

    /**
     * Retrieves the color of the product.
     *
     * @return the color of the product
     */
    public String getColor() {
        return color;
    }

    /**
     * Retrieves the type of the product.
     *
     * @return the type of the product
     */
    public String getType() {
		return type;
	}

    /**
     * Retrieves current stock count of the product.
     *
     * @return current stock count as an Integer
     */
	public Integer getStock() {
        return stock;
    }

	/**
	 * Checks if this product is sold out.
	 *
	 * @return true if sold out, false otherwise 
	 */
    public boolean isSoldOut() {
        return isSoldOut;
    }
    
    
}
