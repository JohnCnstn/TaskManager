package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.UserProfile;
import com.johncnstn.data.service.UserProfileService;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/workers")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> getAllWorkers() {
        UserProfile userProfile = userProfileService.getById(3);
        return ResponseEntity.ok(userService.findAllByUserProfile(userProfile));
    }

    @GetMapping("/managers")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> getAllManagers() {
        UserProfile userProfile = userProfileService.getById(2);
        return ResponseEntity.ok(userService.findAllByUserProfile(userProfile));
    }
}
