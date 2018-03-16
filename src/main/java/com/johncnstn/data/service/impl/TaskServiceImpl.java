package com.johncnstn.data.service.impl;

import com.johncnstn.data.entity.Task;
import com.johncnstn.data.repository.ProjectRepository;
import com.johncnstn.data.repository.TaskRepository;
import com.johncnstn.data.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Qualifier("taskRepository")
    @Autowired
    private TaskRepository taskRepository;

    @Qualifier("projectRepository")
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllByProjectId(long id) {
        return taskRepository.findAllByProject(projectRepository.findOne(id));
    }
}
