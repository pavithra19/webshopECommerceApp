package com.fulda.webshop.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController is a simple REST controller that handles HTTP requests
 * to display a greeting message.
 */
@RestController
public class HelloWorldController
{
	/**
     * Handles GET requests to the root path ("/app" and "/app/").
     *
     * @return a greeting message as a String
     */
    @GetMapping({ "/app", "/app/" })
    public String helloWorld() {
        return "Hello World Everybody"; // Returns a greeting message
    }
}