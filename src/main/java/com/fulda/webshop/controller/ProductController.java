package com.fulda.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fulda.webshop.dto.ProductDetailDTO;
import com.fulda.webshop.facade.ProductDetailFacade;
import com.fulda.webshop.model.Product;
import com.fulda.webshop.repository.ProductRepository;
import com.fulda.webshop.service.InventoryService;
import com.fulda.webshop.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 * ProductController manages requests related to product operations in the webshop.
 * It provides endpoints for viewing, adding, filtering, and deleting products.
 */
@Controller
@RequestMapping("/app/products")
public class ProductController
{
	private final ProductDetailFacade productDetailFacade; // Facade for product-related operations

	/**
     * Constructs a ProductController with the specified ProductDetailFacade.
     *
     * @param productDetailFacade the facade used to manage product details
     */
    @Autowired
    public ProductController(ProductDetailFacade productDetailFacade) {
        this.productDetailFacade = productDetailFacade;
    }
    
    /**
     * Retrieves all products and displays them in the catalog view.
     *
     * @param search optional search query to filter products by name
     * @param edit flag indicating whether to enable edit mode
     * @param model the model to hold attributes for the view
     * @return the name of the view template to render
     */
    @GetMapping // Endpoint to get all products
    public String getAllProducts(@RequestParam(required = false) String search, @RequestParam(required = false, defaultValue = "false") boolean edit, Model model) {
        List<Product> products;
        if (search != null && !search.isEmpty()) {
            products = productDetailFacade.filterProductsByName(search); // Fetch products based on search query
        } else {
            products = productDetailFacade.getAllProducts(); // Fetch all products if no search query is provided
        }
        
        model.addAttribute("products", products);
        model.addAttribute("edit", edit); // Ensure edit variable is added to the model
        model.addAttribute("search", search); // Add search string to model for displaying in input field
        return "catalog"; // Return catalog view
    }

    /**
     * Retrieves products filtered by color and displays them in the catalog view.
     *
     * @param color the color to filter products by
     * @param edit flag indicating whether to enable edit mode
     * @param model the model to hold attributes for the view
     * @return the name of the view template to render
     */
    @GetMapping("/filter_by=color/{color}") // Endpoint for filtering by color
    public String getProductsByColor(@PathVariable String color, @RequestParam(required = false, defaultValue = "false") boolean edit, Model model) {
        List<Product> filteredProducts = productDetailFacade.filterProductsByColor(color);
        model.addAttribute("products", filteredProducts);
        model.addAttribute("edit", edit); // Ensure edit variable is added to the model
        return "catalog"; // Return catalog view with filtered products
    }

    /**
     * Retrieves detailed information about a specific product by its ID.
     *
     * @param id the ID of the product to retrieve details for
     * @param model the model to hold attributes for the view
     * @return the name of the view template to render, or an error page if not found
     */
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
       
    	try {
            ProductDetailDTO productDetailDTO = productDetailFacade.getProductDetailById(id); // Fetch product by ID from database
            model.addAttribute("productDetailDTO", productDetailDTO);
            return "productDetails"; // Return product details view
        } catch (IllegalArgumentException e) {
            return "error";
        }
    }
    
    /**
     * Deletes a specific product by its ID and redirects back to the catalog page.
     *
     * @param id the ID of the product to delete
     * @return a redirect URL for navigating back to the products page after deletion
     */
    @GetMapping("/delete/{id}") // Delete a product by ID
    public String deleteProduct(@PathVariable Long id) {
    	productDetailFacade.deleteProduct(id);
        return "redirect:/app/products/catalog-paginated?edit=true"; // Redirect back to the products page after deletion
    }

    /**
     * Displays the page for adding a new product.
     *
     * @return the name of the view template for adding a new product
     */
    @GetMapping("/add")
	public String getAddProductPage() {
    	return "addProduct";
    }
  
    /**
     * Handles adding a new product based on form submission.
     *
     * @param newProduct the new Product object submitted from the form
     * @return a redirect URL for navigating to the newly created product's details page
     */
	 @PostMapping
	 public String addProduct(@ModelAttribute Product newProduct) {
      Product createdProduct = productDetailFacade.addProduct(newProduct);
      return "redirect:/app/products/" + createdProduct.getId(); // Redirect back to the products details page
	 }
	 
	 /**
     * Retrieves all products with pagination support and displays them in a paginated catalog view.
     *
     * @param search optional search query to filter products by name 
     * @param pageable pagination information including page number and size 
     * @param model the model to hold attributes for the view 
     * @return the name of the view template for paginated results 
     */
	 @GetMapping("/catalog-paginated") // New endpoint for paginated catalog
	 public String getPaginatedProducts(@RequestParam(required = false) String search,
	                                     @PageableDefault(size = 3) Pageable pageable,
                                      Model model)
	 {
	     Page<Product> productsPage; // Use Page<Product> for pagination
	     
	     if (search != null && !search.isEmpty())
	     {
	         productsPage = productDetailFacade.filterProductsByName(search, pageable); // Fetch products based on search query with pagination
	     } else {
	         productsPage = productDetailFacade.getPaginatedProducts(pageable); // Fetch all products with pagination
      }
	     
	     model.addAttribute("products", productsPage.getContent()); // Get the content of the page
	     model.addAttribute("currentPage", productsPage); // Pass the whole page object for navigation
	     model.addAttribute("search", search); // Add search string to model for displaying in input field

	     return "catalogPaginated"; // Return new catalog view for paginated results
	 }
    
//    
//  @GetMapping({ "", "/" })
//  public ResponseEntity<List<Product>> getAllProducts()
//  {
//      List<Product> allProducts = productService.getAllProducts();
//      return new ResponseEntity<>(allProducts, HttpStatus.OK);
//  }
}