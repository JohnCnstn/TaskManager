package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/myLogin")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> myLogin(@RequestBody User user) {
        User found = userService.findByUserName(user.getUserName());
        if (found.getUserProfile().getType().equalsIgnoreCase("WORKER")) {
            return new ResponseEntity<>("WORKER", HttpStatus.OK);
        } else if (found.getUserProfile().getType().equalsIgnoreCase("ADMIN")) {
            return new ResponseEntity<>("ADMIN", HttpStatus.OK);
        } else if (found.getUserProfile().getType().equalsIgnoreCase("MANAGER")) {
            return new ResponseEntity<>("MANAGER", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("none", HttpStatus.BAD_REQUEST);
        }
    }
}
