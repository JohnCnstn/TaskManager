package com.johncnstn.data.service.impl;

import com.johncnstn.data.dto.ProjectDto;
import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Project;
import com.johncnstn.data.repository.ManagerRepository;
import com.johncnstn.data.repository.ProjectRepository;
import com.johncnstn.data.repository.WorkerRepository;
import com.johncnstn.data.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Qualifier("projectRepository")
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Qualifier("workerRepository")
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override
    public Project findOne(long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public Project createNewProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setQuantity(projectDto.getQuantity());

        project.setManager(managerRepository.findOne(projectDto.getManagerId()));

        project.setWorker(workerRepository.findOne(projectDto.getWorkerId()));

        return projectRepository.save(project);
    }
}
