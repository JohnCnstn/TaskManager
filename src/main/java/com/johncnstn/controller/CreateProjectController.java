package com.johncnstn.controller;

import com.johncnstn.data.dto.ProjectDto;
import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Project;
import com.johncnstn.data.service.ManagerService;
import com.johncnstn.data.service.ProjectService;
import com.johncnstn.data.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ManagerService managerService;

    @GetMapping("/createProject")
    public String getCreateProject(Model model) {
        model.addAttribute("project", new ProjectDto());
        model.addAttribute("managerList", managerService.findAll());
        model.addAttribute("workerList", workerService.findAll());
        return "/createProject";
    }

    @PostMapping("/createProject")
    public String postProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult result) {
        if (!result.hasErrors()) {
            createProject(projectDto, result);
        }
        if (result.hasErrors()) {
            return "registration";
        } else {
            return "redirect:login.html";
        }
    }

    private Project createProject(ProjectDto projectDto, BindingResult result) {
        Project project;
        project = projectService.createNewProject(projectDto);
        return project;
    }

}
