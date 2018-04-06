package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.Project;
import com.johncnstn.data.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Project>> projects() {
        return ResponseEntity.ok(projectService.findAll());
    }
}
