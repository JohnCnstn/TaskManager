package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyLoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/myLogin")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity myLogin(@RequestBody User user) {
        User found = userService.findByUserName(user.getUserName());
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
