package com.johncnstn.data.service;

import com.johncnstn.data.dto.ProjectDto;
import com.johncnstn.data.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> findAll();
    void delete(long id);
    Project findOne(long id);
<<<<<<< HEAD
=======
    Project findByName(String name);
    Project findByDescription(String description);
    Project findByQuantity(long id);
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
    void createNewProject(ProjectDto projectDto);
    void updateProject(Project project);
}
