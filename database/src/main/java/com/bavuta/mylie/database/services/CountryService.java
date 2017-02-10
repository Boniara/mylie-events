package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.CountryMapper;
import com.bavuta.mylie.database.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Transactional(rollbackFor = Exception.class)
    public Country getCountryById(Long id) {
        Country country = countryMapper.getCountryById(id);
        return country;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Country> getAllCountries() {
        List<Country> countryList = countryMapper.getAllCountries();
        return countryList;
    }
}
