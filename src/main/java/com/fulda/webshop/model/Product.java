package com.fulda.webshop.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

/**
 * Represents a product in the system with its attributes such as name, price, and type.
 */
@Entity
@NamedQuery(
    name = "Product.fetchAllProductsWithName",
    query = "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))"
)
public class Product
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate ID
    private Long id; // Unique identifier for each product
    private String name;
    private BigDecimal price;
    private String size;
    private String color;
    private String type;
    private String description;
    
    // Default constructor (required by JPA)
    public Product() {}

    /**
     * Constructs a Product with specified attributes.
     *
     * @param id unique identifier of the product
     * @param name name of the product
     * @param price price of the product
     * @param size size of the product
     * @param color color of the product
     * @param description description of the product
     * @param type type of the product
     */
    public Product(Long id, String name, BigDecimal price, String size, String color, String description, String type)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.type = type;
        this.description = description;
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
    
    // No public getter method for description attribute.
    
    /**
     * Sets the unique identifier for the product.
     *
     * @param id the new ID to set for the product
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets a new name for the product.
     *
     * @param name the new name to set for the product
     */
	public void setName(String name) 
	{
		this.name = name;
	}

	 /**
     * Sets a new description for the product.
     *
     * @param description the new description to set for the product
     */
	public void setDescription(String description) {
		this.description = description;
	}

	 /**
     * Sets a new price for the product.
     *
     * @param price the new price to set for the product
     */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
     * Sets a new size for the product.
     *
     * @param size the new size to set for the product
     */
	public void setSize(String size) {
		this.size = size;
	}

	/**
     * Sets a new color for the product.
     *
     * @param color the new color to set for the product
     */
	public void setColor(String color) {
		this.color = color;
	}

	/**
     * Sets a new type for the product.
     *
     * @param type the new type to set for the product
     */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Assuming 'id' is a unique identifier.
	 * This method is to update quantity in cart.
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Product)) return false;
	    Product other = (Product) obj;
	    return this.id.equals(other.id);
	}

	/**
	 * Use unique identifier for hashing.
	 */
	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
	
	
}