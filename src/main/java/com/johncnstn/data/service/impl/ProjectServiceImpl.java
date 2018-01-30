package com.johncnstn.data.service.impl;

import com.johncnstn.data.dto.ProjectDto;
import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Project;
import com.johncnstn.data.entity.Worker;
import com.johncnstn.data.repository.ManagerRepository;
import com.johncnstn.data.repository.ProjectRepository;
import com.johncnstn.data.repository.WorkerRepository;
import com.johncnstn.data.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
    public void createNewProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setQuantity(projectDto.getQuantity());

        project.setManager(managerRepository.findOne(projectDto.getManagerId()));

        projectRepository.save(project);

        for (long id : projectDto.getWorkerId()) {
            Worker worker = workerRepository.findOne(id);
            worker.setProject(project);
            workerRepository.save(worker);
        }
    }
}
