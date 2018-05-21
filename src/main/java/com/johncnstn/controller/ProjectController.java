//package com.johncnstn.controller;
//
//import com.johncnstn.data.dto.CountryDto;
//import com.johncnstn.data.entity.Country;
//import com.johncnstn.data.service.ManagerService;
//import com.johncnstn.data.service.CountryService;
//import com.johncnstn.data.service.TourService;
//import com.johncnstn.data.service.ClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@Controller
//public class ProjectController {
//
//    @Autowired
//    private ClientService workerService;
//
//    @Autowired
//    private ManagerService managerService;
//
//    @Autowired
//    private CountryService projectService;
//
//    @Autowired
//    private TourService taskService;
//
//    @GetMapping("/country/{id}")
//    public String getProject(@PathVariable(value = "id") Long id, Model model) {
//        model.addAttribute("taskList", taskService.findAllByCountryId(id));
//        return "/country";
//    }
//
//    @GetMapping("/updateCountry/{id}")
//    public String getUpdateProject(@PathVariable(value = "id") Long id, Model model) {
//        model.addAttribute("country", projectService.findOne(id));
//        model.addAttribute("managerList", managerService.findAll());
//        model.addAttribute("workerList", workerService.findAll());
//        return "/updateCountry";
//    }
//
//    @PostMapping("/updateCountry/{id}")
//    public String updateCountry(@Valid @ModelAttribute("country") Country country, @PathVariable(value = "id") Long id,
//                                BindingResult result) {
//        if (!result.hasErrors()) {
//            country.setId(id);
//            updateCountry(country);
//        }
//        if (result.hasErrors()) {
//            return "registration";
//        } else {
//            return "redirect:/home";
//        }
//    }
//
//    @DeleteMapping("/country/{id}")
//    public String deleteProject(@PathVariable(value = "id") Long id, Model model) {
//        model.addAttribute("country", projectService.findOne(id));
//        projectService.delete(id);
//        return "redirect:/home";
//    }
//
//    @GetMapping("/createProject")
//    public String getCreateProject(Model model) {
//        model.addAttribute("country", new CountryDto());
//        model.addAttribute("managerList", managerService.findAll());
//        model.addAttribute("workerList", workerService.findAll());
//        return "/createProject";
//    }
//
//    @PostMapping("/createProject")
//    public String postProject(@Valid @ModelAttribute("country") CountryDto projectDto, BindingResult result) {
//        if (!result.hasErrors()) {
//            createProject(projectDto, result);
//        }
//        if (result.hasErrors()) {
//            return "registration";
//        } else {
//            return "redirect:/home";
//        }
//    }
//
//    private void createProject(CountryDto projectDto, BindingResult result) {
//        projectService.createNewCountry(projectDto);
//    }
//
//    private void updateCountry(Country country) {
//        projectService.updateCountry(country);
//    }
//
//}
