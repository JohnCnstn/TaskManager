package com.johncnstn.data.service.impl;

import com.johncnstn.data.dto.CountryDto;
import com.johncnstn.data.entity.Client;
import com.johncnstn.data.entity.Country;
import com.johncnstn.data.repository.ManagerRepository;
import com.johncnstn.data.repository.CountryRepository;
import com.johncnstn.data.repository.ClientRepository;
import com.johncnstn.data.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Qualifier("countryRepository")
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Qualifier("clientRepository")
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void delete(long id) {
        countryRepository.delete(id);
    }

    @Override
    public Country findOne(long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Country findByDescription(String description) {
        return countryRepository.findByDescription(description);
    }

    @Override
    public Country findByQuantity(long id) {
        return countryRepository.findByQuantity(id);
    }

    @Override
    public void createNewCountry(CountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        country.setDescription(countryDto.getDescription());
        country.setQuantity(countryDto.getQuantity());

        country.setManager(managerRepository.findOne(countryDto.getManager().getId()));

        countryRepository.save(country);

        for (Client client : countryDto.getClients()) {
            Client clientToSave = clientRepository.findOne(client.getId());
            clientToSave.setCountry(country);
            clientRepository.save(clientToSave);
        }
    }

    @Override
    public void updateCountry(Country country) {
        Country countryToSave = countryRepository.findOne(country.getId());
        countryToSave.setName(country.getName());
        countryToSave.setDescription(country.getDescription());
        countryToSave.setQuantity(country.getQuantity());

        countryToSave.setManager(managerRepository.findOne(country.getManager().getId()));

        countryRepository.save(countryToSave);

        for (Client client : country.getClients()) {
            Client clientToSave = clientRepository.findOne(client.getId());
            clientToSave.setCountry(country);
            clientRepository.save(clientToSave);
        }
    }
}
