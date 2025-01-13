package com.fulda.webshop.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fulda.webshop.facade.AddToCartFacade;
import com.fulda.webshop.model.ShoppingCart;
import com.fulda.webshop.service.ShoppingCartService;

/**
 * ShoppingCartController manages requests related to shopping cart operations.
 * It provides endpoints for viewing and modifying items in the shopping cart.
 */
@Controller
@RequestMapping("/app/cart")
public class ShoppingCartController {

	private final AddToCartFacade addToCartFacade; // Facade for adding products to cart 
	private final ShoppingCartService shoppingCartService; // Service for managing shopping cart operations

	/**
	 * Constructs a ShoppingCartController with specified services.
	 *
	 * @param shoppingCartService service used to manage shopping cart operations 
	 * @param addToCartFacade facade used for adding items to cart 
	 */
	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService, AddToCartFacade addToCartFacade) {
		this.shoppingCartService = shoppingCartService;
		this.addToCartFacade = addToCartFacade;
	}

	/**
	 * Displays the complete contents of the shopping cart.
	 *
	 * @param model the model to hold attributes for rendering views 
	 * @return the name of the view template for displaying cart contents 
	 */
	@GetMapping // View the complete shopping cart content
	public String viewCart(Model model) {
		ShoppingCart cart = shoppingCartService.getShoppingCart();
		model.addAttribute("cart", cart);
		return "cart"; // Return cart.html template
	}
	
	/**
	 * Adds a specified product to the shopping cart based on its ID.
	 *
	 * @param id ID of the product to add 
	 * @param redirectAttributes attributes used for redirecting with flash messages 
	 * @return redirect URL for viewing updated cart or catalog page with error message if stock is insufficient 
	 */
	@GetMapping("/add/{id}") // Adding products to the cart
    public String addProductToCart(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            ShoppingCart updatedCart = addToCartFacade.addToCart(id); // Use facade to add product to cart
            redirectAttributes.addFlashAttribute("cart", updatedCart); // Add updated cart to model
            return "redirect:/app/cart"; // Redirect to view the cart
        } catch (IllegalStateException e) {
        	redirectAttributes.addFlashAttribute("errorMessage", e.getMessage()); // Pass error message to model
            return "redirect:/app/products/catalog-paginated"; // Redirect back to catalog page with error message
        }
    }
}