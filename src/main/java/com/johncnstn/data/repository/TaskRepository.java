package com.johncnstn.data.repository;

import com.johncnstn.data.entity.Project;
import com.johncnstn.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByProject(Project project);
    Task findByName(String name);
}
