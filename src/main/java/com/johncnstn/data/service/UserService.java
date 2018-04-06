package com.johncnstn.data.service;

import com.johncnstn.data.entity.User;
<<<<<<< HEAD
=======
import com.johncnstn.data.entity.UserProfile;
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
<<<<<<< HEAD
    List<User> findAll();

=======
    List<User> findAllByUserProfile(UserProfile userProfile);
    List<User> findAll();
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByUserName(String userName);
    User findByEmail(String email);
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
}
