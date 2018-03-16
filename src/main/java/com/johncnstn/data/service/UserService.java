package com.johncnstn.data.service;

import com.johncnstn.data.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

}
