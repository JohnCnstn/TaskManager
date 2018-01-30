package com.johncnstn.data.repository;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("workerRepository")
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
