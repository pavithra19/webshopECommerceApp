package com.fulda.webshop.model;

/**
* User represents an individual user within the webshop system. 
* It contains personal details such as username, email, first name, last name, and role. 
*/
public class User
{
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String role;

    /**
     * Constructs a User with specified attributes. 
     *
     * @param id unique identifier for user 
     * @param username chosen username for user 
     * @param email email address associated with user account 
     * @param firstName first name of user 
     * @param lastName last name of user  
     * @param role role assigned to user (e.g., CUSTOMER or ADMIN)
     */
    public User(Long id, String username, String email, String firstName, String lastName, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    /** Retrieves unique identifier of user. */
    public Long getId() { return id; }
    
    /** Retrieves username associated with user. */
    public String getUsername() { return username; }
    
    /** Retrieves email address associated with user. */
    public String getEmail() { return email; }
    
    /** Retrieves first name of user. */
    public String getFirstName() { return firstName; }
    
    /** Retrieves last name of user. */
    public String getLastName() { return lastName; }
    
    /** Retrieves role assigned to user. */
    public String getRole() { return role; }
}