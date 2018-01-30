package com.johncnstn.data.service;

import com.johncnstn.data.entity.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {
    List<Manager> findAll();
}
