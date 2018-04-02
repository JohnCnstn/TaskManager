package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.Task;
import com.johncnstn.data.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Task>> projects() {
        return ResponseEntity.ok(taskService.findAll());
    }
}
