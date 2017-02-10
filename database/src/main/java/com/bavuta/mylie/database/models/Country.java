package com.bavuta.mylie.database.models;

import java.util.List;

/**
 * Created by bogdan on 11/12/2016.
 */
public class Country extends AbstractModel {

    private String code;
    private String name;
    private List<City> cityList;
    private List<Language> languageList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }
}
