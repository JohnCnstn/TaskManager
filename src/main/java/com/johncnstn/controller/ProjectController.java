package com.johncnstn.controller;

import com.johncnstn.data.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project/{id}")
    public String getProject(@PathVariable(value = "id") Long id) {
        return "/project";
    }

    @GetMapping("/updateProject/{id}")
    public String getUpdateProject(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("project", projectService.findOne(id));
        return "/updateProject";
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("project", projectService.findOne(id));
        projectService.delete(id);
        return "redirect:/home";
    }

}
