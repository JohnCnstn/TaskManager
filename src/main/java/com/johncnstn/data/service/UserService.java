package com.johncnstn.data.service;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.User;
import com.johncnstn.exception.EmailExistsException;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException, EmailExistsException;
}
