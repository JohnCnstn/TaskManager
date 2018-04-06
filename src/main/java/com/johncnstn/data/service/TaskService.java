package com.johncnstn.data.service;

import com.johncnstn.data.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
<<<<<<< HEAD
=======
    Task findByName(String name);
    Task findByPath(String path);
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
    List<Task> findAll();
    List<Task> findAllByProjectId(long id);
}
