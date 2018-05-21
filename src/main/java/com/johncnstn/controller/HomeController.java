package com.johncnstn.controller;

import com.johncnstn.data.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("countryList", countryService.findAll());
        return "/home";
    }
//    @GetMapping("/")
//    public String home() {
//        return "/index";
//    }

}
