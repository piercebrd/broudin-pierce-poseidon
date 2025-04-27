package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller that handles login and access denied (403) pages.
 */
@Controller
public class LoginController {

    /**
     * Displays the login page.
     *
     * @return the login view name
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Displays the 403 (Access Denied) error page.
     *
     * @return the 403 view name
     */
    @GetMapping("/403")
    public String error403() {
        return "403";
    }
}
