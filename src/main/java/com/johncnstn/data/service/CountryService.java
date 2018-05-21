package com.johncnstn.data.service;

import com.johncnstn.data.dto.CountryDto;
import com.johncnstn.data.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    List<Country> findAll();
    void delete(long id);
    Country findOne(long id);
    Country findByName(String name);
    Country findByDescription(String description);
    Country findByQuantity(long id);
    void createNewCountry(CountryDto countryDto);
    void updateCountry(Country country);
}
