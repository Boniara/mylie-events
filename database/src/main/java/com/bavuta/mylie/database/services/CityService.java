package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.CityMapper;
import com.bavuta.mylie.database.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    @Transactional(rollbackFor = Exception.class)
    public City getCityById(Long id) {
        City city = cityMapper.getCityById(id);
        return city;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<City> getAllCities() {
        List<City> cityList = cityMapper.getAllCities();
        return cityList;
    }
}
