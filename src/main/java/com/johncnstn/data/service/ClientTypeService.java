package com.johncnstn.data.service;

import com.johncnstn.data.entity.ClientType;
import org.springframework.stereotype.Service;

@Service
public interface ClientTypeService {
    ClientType getByType(String type);
}
