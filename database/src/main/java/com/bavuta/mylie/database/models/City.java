package com.bavuta.mylie.database.models;

/**
 * Created by bogdan on 11/12/2016.
 */
public class City extends AbstractModel {

    private String name;
    private String district;
    private Integer population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
