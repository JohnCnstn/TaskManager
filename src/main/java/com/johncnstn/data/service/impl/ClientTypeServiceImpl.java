package com.johncnstn.data.service.impl;

import com.johncnstn.data.entity.ClientType;
import com.johncnstn.data.repository.CleintTypeRepository;
import com.johncnstn.data.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    @Autowired
    private CleintTypeRepository cleintTypeRepository;

    @Override
    public ClientType getByType(String type) {
        return cleintTypeRepository.findByType(type);
    }
}
