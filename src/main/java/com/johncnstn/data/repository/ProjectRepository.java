package com.johncnstn.data.repository;

import com.johncnstn.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("projectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);
    Project findByDescription(String description);
}
