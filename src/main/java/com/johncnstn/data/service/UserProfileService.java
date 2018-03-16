package com.johncnstn.data.service;


import com.johncnstn.data.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProfileService {
    UserProfile getById(long id);
    UserProfile getByType(String type);
    List<UserProfile> getAll();
}
