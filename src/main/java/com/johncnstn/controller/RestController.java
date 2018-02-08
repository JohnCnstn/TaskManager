package com.johncnstn.controller;

import com.johncnstn.data.entity.Project;
import com.johncnstn.data.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Project>> getAllEmployees() {
        List<Project> employees = projectService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
