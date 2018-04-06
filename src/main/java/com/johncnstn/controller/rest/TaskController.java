package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.Task;
import com.johncnstn.data.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/tasks/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable("id") long id) {
        return ResponseEntity.ok(taskService.findAllByProjectId(id));
    }
}
