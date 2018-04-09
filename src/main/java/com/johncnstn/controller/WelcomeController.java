package com.johncnstn.controller;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestBody User user) {
        User found = userService.findByUserName(user.getUserName());
        if (found == null) {
            return "/error";
        } else {
            return "/login";
        }
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
