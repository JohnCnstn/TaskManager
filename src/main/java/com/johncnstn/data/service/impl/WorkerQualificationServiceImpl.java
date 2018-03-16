package com.johncnstn.data.service.impl;

import com.johncnstn.data.entity.WorkerQualification;
import com.johncnstn.data.repository.WorkerQualificationRepository;
import com.johncnstn.data.service.WorkerQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerQualificationServiceImpl implements WorkerQualificationService {

    @Autowired
    private WorkerQualificationRepository workerQualificationRepository;

    @Override
    public WorkerQualification getByType(String type) {
        return workerQualificationRepository.findByType(type);
    }
}
