package com.johncnstn.data.service;

import com.johncnstn.data.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> findAll();
}
