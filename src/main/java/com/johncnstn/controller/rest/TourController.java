package com.johncnstn.controller.rest;

import com.johncnstn.data.dto.TourDto;
import com.johncnstn.data.entity.Tour;
import com.johncnstn.data.service.CountryService;
import com.johncnstn.data.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/tours")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Tour>> getTours() {
        return ResponseEntity.ok(tourService.findAll());
    }

    @PostMapping("/tours")
    @CrossOrigin(origins = "http://localhost:3000")
    public void setTour(@RequestBody TourDto tourDto) {
        Tour newTour = new Tour();
        newTour.setName(tourDto.getName());
        newTour.setDate(tourDto.getDate());

        newTour.setCountry(countryService.findOne(tourDto.getCountryId()));

        tourService.save(newTour);
    }

    @PutMapping("/tours")
    @CrossOrigin(origins = "http://localhost:3000")
    public void putTour(@RequestBody TourDto tourDto) {
        Tour newTour = tourService.findOne(tourDto.getTourId());
        newTour.setName(tourDto.getName());
        newTour.setDate(tourDto.getDate());
        tourService.save(newTour);
    }

    @GetMapping("/tours/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Tour>> getToursByCountryId(@PathVariable("id") long id) {
        return ResponseEntity.ok(tourService.findAllByCountryId(id));
    }

    @DeleteMapping("/tours/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteTour(@PathVariable("id") long id) {
        tourService.delete(id);
    }
}
