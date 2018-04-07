package com.johncnstn.controller.rest;

import com.johncnstn.data.dto.TaskDto;
import com.johncnstn.data.entity.Task;
import com.johncnstn.data.service.ProjectService;
import com.johncnstn.data.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:3000")
    public void setTask(@RequestBody TaskDto taskDto) {
        Task newTask = new Task();
        newTask.setName(taskDto.getName());
        newTask.setPath(taskDto.getPath());

        newTask.setProject(projectService.findOne(taskDto.getProjectId()));

        taskService.save(newTask);
    }

    @PutMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:3000")
    public void putTask(@RequestBody TaskDto taskDto) {
        Task newTask = taskService.findOne(taskDto.getTaskId());
        newTask.setName(taskDto.getName());
        newTask.setPath(taskDto.getPath());
        taskService.save(newTask);
    }

    @GetMapping("/tasks/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable("id") long id) {
        return ResponseEntity.ok(taskService.findAllByProjectId(id));
    }

    @DeleteMapping("/tasks/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteTask(@PathVariable("id") long id) {
        taskService.delete(id);
    }
}
