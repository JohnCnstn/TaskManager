package com.johncnstn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectController {
    @GetMapping("/project/{id}")
    public String getProject(@PathVariable(value = "id") Long id) {
        return "/project";
    }
}
