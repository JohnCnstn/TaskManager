package com.johncnstn.data.repository;

import com.johncnstn.data.entity.Country;
import com.johncnstn.data.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tourRepository")
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findAllByCountry(Country country);
    Tour findByName(String name);
    Tour findByDate(String date);
}
