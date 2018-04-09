package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.Project;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.Worker;
import com.johncnstn.data.service.ProjectService;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @GetMapping("/projects")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Project>> projects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/project/{userName}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Project>> projectsByUserName(@PathVariable("userName") String userName) {
        Worker worker = (Worker) userService.findByUserName(userName);
        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Project> projects = new ArrayList<>();
            projects.add(projectService.findOne(worker.getProject().getId()));
            return ResponseEntity.ok(projects);
        }
    }
}
