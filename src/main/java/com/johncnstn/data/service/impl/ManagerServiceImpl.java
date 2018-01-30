package com.johncnstn.data.service.impl;

import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.repository.ManagerRepository;
import com.johncnstn.data.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }
}
