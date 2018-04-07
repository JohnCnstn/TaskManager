package com.johncnstn.data.service;

import com.johncnstn.data.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    void delete(long id);
    void save(Task task);
    Task findByName(String name);
    Task findByPath(String path);
    Task findOne(long id);
    List<Task> findAll();
    List<Task> findAllByProjectId(long id);
}
