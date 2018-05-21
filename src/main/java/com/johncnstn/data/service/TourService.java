package com.johncnstn.data.service;

import com.johncnstn.data.entity.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService {
    void delete(long id);
    void save(Tour tour);
    Tour findByName(String name);
    Tour findByDate(String date);
    Tour findOne(long id);
    List<Tour> findAll();
    List<Tour> findAllByCountryId(long id);
}
