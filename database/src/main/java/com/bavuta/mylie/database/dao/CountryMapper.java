package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.Country;

import java.util.List;

/**
 * Created by bogdan on 11/13/2016.
 */
public interface CountryMapper {
    Country getCountryById(Long id);
    List<Country> getAllCountries();
}
