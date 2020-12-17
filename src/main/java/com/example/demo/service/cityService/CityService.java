package com.example.demo.service.cityService;

import com.example.demo.model.City;
import com.example.demo.service.GeneralService;

import java.util.Optional;

public interface CityService extends GeneralService<City> {
    Iterable<City> findAll();

    Optional<City> findById(Integer id);

    City save(City city);

    void delete(City city);
}
