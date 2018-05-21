package com.johncnstn.data.repository;

import com.johncnstn.data.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
    Country findByDescription(String description);
    Country findByQuantity(long id);
}
