package com.johncnstn.controller.rest;

import com.johncnstn.data.entity.Client;
import com.johncnstn.data.entity.Country;
import com.johncnstn.data.service.CountryService;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;

    @GetMapping("/countries")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Country>> countries() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/country/{userName}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Country>> countriesByUserName(@PathVariable("userName") String userName) {
        Client client = (Client) userService.findByUserName(userName);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Country> countries = new ArrayList<>();
            countries.add(countryService.findOne(client.getCountry().getId()));
            return ResponseEntity.ok(countries);
        }
    }
}
