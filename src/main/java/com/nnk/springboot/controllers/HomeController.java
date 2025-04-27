package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller that handles the home page after successful login.
 */
@Controller
public class HomeController {

    /**
     * Displays the home page.
     *
     * @return the home view name
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
