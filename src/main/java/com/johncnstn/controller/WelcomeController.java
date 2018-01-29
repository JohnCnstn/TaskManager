package com.johncnstn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping({"/", "/login"})
    public String home1() {
        return "/login";
    }

    @GetMapping("/home")
    public String user() {
        return "/home";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
