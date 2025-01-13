package com.fulda.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fulda.webshop.model.User;
import com.fulda.webshop.service.UserService;

import java.util.List;

/**
* UserController manages requests related to user operations within the webshop.
* It provides endpoints for retrieving and creating user accounts.
*/
@RestController
@RequestMapping("/app/users")
public class UserController
{

    private final UserService userService; // Service used for managing user accounts

    /**
     * Constructs a UserController with specified UserService.
     *
     * @param userService service used to manage user accounts 
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all registered users in response to GET requests.
     *
     * @return ResponseEntity containing list of users in HTTP response body  
     */
    @GetMapping({ "", "/" })
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    /**
     * Handles requests for adding a new user based on provided first and last names.
     *
     * @param firstname first name of new user  
     * @param lastname last name of new user  
     * @return ResponseEntity containing newly created user in HTTP response body  
     */
    @PostMapping
    public ResponseEntity<User> addUser(@RequestParam String firstname, @RequestParam String lastname) {
        User newUser = userService.addUser(firstname, lastname);
        return ResponseEntity.ok(newUser); // Return the newly created user
    }
}