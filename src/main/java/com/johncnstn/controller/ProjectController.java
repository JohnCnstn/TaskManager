package com.johncnstn.controller;

import com.johncnstn.data.dto.ProjectDto;
import com.johncnstn.data.entity.Project;
import com.johncnstn.data.service.ManagerService;
import com.johncnstn.data.service.ProjectService;
import com.johncnstn.data.service.TaskService;
import com.johncnstn.data.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProjectController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/project/{id}")
    public String getProject(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("taskList", taskService.findAllByProjectId(id));
        return "/project";
    }

    @GetMapping("/updateProject/{id}")
    public String getUpdateProject(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("project", projectService.findOne(id));
        model.addAttribute("managerList", managerService.findAll());
        model.addAttribute("workerList", workerService.findAll());
        return "/updateProject";
    }

    @PostMapping("/updateProject/{id}")
    public String updateProject(@Valid @ModelAttribute("project") Project project, @PathVariable(value = "id") Long id,
                                BindingResult result) {
        if (!result.hasErrors()) {
            project.setId(id);
            updateProject(project);
        }
        if (result.hasErrors()) {
            return "registration";
        } else {
            return "redirect:/home";
        }
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("project", projectService.findOne(id));
        projectService.delete(id);
        return "redirect:/home";
    }

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
            return "redirect:/home";
        }
    }

    private void createProject(ProjectDto projectDto, BindingResult result) {
        projectService.createNewProject(projectDto);
    }

    private void updateProject(Project project) {
        projectService.updateProject(project);
    }

}
