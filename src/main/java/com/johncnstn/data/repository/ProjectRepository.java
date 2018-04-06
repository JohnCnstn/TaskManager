package com.johncnstn.data.repository;

import com.johncnstn.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("projectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long> {
<<<<<<< HEAD
=======
    Project findByName(String name);
    Project findByDescription(String description);
    Project findByQuantity(long id);
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
}
