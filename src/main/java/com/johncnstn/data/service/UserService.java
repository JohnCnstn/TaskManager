package com.johncnstn.data.service;

import com.johncnstn.data.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
