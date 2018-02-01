package com.johncnstn.data.repository;

import com.johncnstn.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Long> {
}
