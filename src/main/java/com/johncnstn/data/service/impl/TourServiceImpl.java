package com.johncnstn.data.service.impl;

import com.johncnstn.data.entity.Tour;
import com.johncnstn.data.repository.CountryRepository;
import com.johncnstn.data.repository.TourRepository;
import com.johncnstn.data.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Qualifier("tourRepository")
    @Autowired
    private TourRepository tourRepository;

    @Qualifier("countryRepository")
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void delete(long id) {
        tourRepository.delete(id);
    }

    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public Tour findByName(String name) {
        return tourRepository.findByName(name);
    }

    @Override
    public Tour findByDate(String date) {
        return tourRepository.findByDate(date);
    }

    @Override
    public Tour findOne(long id) {
        return tourRepository.findOne(id);
    }

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> findAllByCountryId(long id) {
        return tourRepository.findAllByCountry(countryRepository.findOne(id));
    }
}
