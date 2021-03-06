package com.johncnstn.data.service;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.Worker;
import com.johncnstn.exception.EmailExistsException;

import java.util.List;

public interface WorkerService {
    User findUserByEmail(String email);
    Worker registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
    List<Worker> findAll();
}
