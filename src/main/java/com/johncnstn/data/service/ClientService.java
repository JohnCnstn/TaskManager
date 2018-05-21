package com.johncnstn.data.service;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.Client;
import com.johncnstn.data.entity.User;
import com.johncnstn.exception.EmailExistsException;

import java.util.List;

public interface ClientService {
    User findUserByEmail(String email);
    Client registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
    List<Client> findAll();
}
