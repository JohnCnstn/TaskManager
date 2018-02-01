package com.johncnstn.data.service;

import com.johncnstn.data.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<Task> findAll();
}
