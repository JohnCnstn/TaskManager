package com.johncnstn.data.repository;

import com.johncnstn.data.entity.WorkerQualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerQualificationRepository extends JpaRepository<WorkerQualification, Long> {
    WorkerQualification findByType(String type);
}
