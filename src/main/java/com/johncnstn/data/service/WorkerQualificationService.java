package com.johncnstn.data.service;

import com.johncnstn.data.entity.WorkerQualification;
import org.springframework.stereotype.Service;

@Service
public interface WorkerQualificationService {
    WorkerQualification getByType(String type);
}
