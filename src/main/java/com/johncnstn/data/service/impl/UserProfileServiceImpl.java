package com.johncnstn.data.service.impl;

import com.johncnstn.data.entity.UserProfile;
import com.johncnstn.data.repository.UserProfileRepository;
import com.johncnstn.data.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getById(long id) {
        return userProfileRepository.findOne(id);
    }

    @Override
    public UserProfile getByType(String type) {
        return userProfileRepository.findByType(type);
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
