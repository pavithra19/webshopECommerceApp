package com.fulda.webshop.service;

import org.springframework.stereotype.Service;

import com.fulda.webshop.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService manages user accounts within the webshop.
 * It provides functionality to retrieve and add users.
 */
@Service
public class UserService
{
    private List<User> users = new ArrayList<>(); // List holding registered users

    /**
     * Initializes UserService with hardcoded user entries for demonstration purposes.
     */
    public UserService()
    {
        // Hardcoded user entries
        users.add(new User(10001L, "john_doe", "john.doe@example.com", "John", "Doe", "CUSTOMER"));
        users.add(new User(10002L, "jane_smith", "jane.smith@example.com", "Jane", "Smith", "ADMIN"));
        users.add(new User(10003L, "bob_johnson", "bob.johnson@example.com", "Bob", "Johnson", "CUSTOMER"));
    }

    /**
     * Retrieves all registered users.
     *
     * @return a list of all users in the system 
     */
    public List<User> getAllUsers() {
        return users; // Return list of users 
    }
    
    /**
     * Adds a new user with generated credentials based on first and last names.
     *
     * @param firstname user's first name 
     * @param lastname user's last name 
     * @return newly created user object 
     */
    public User addUser(String firstname, String lastname) {
        Long newId = (long) (users.size() + 1); // Simple ID generation logic
        User newUser = new User(newId, firstname + "_" +lastname, firstname + "." + lastname + "@example.com", firstname, lastname, "CUSTOMER");
        users.add(newUser);
        return newUser; // Returns the newly created user
    }
}