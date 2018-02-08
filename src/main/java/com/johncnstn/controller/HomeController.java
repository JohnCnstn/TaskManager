package com.johncnstn.controller;

import com.johncnstn.data.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("projectList", projectService.findAll());
        return "/home";
    }

    @GetMapping("/reactPage")
    public String reactPage() {
        return "/react/reactPage";
    }

}
