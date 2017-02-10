package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.City;

import java.util.List;

/**
 * Created by bogdan on 11/13/2016.
 */
public interface CityMapper {

    City getCityById(Long id);
    List<City> getAllCities();
}
