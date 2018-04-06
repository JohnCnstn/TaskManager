package com.johncnstn.data.service;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAllByUserProfile(UserProfile userProfile);
    List<User> findAll();
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByUserName(String userName);
    User findByEmail(String email);
}
