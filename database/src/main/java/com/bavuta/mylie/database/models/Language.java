package com.bavuta.mylie.database.models;

/**
 * Created by bogdan on 11/12/2016.
 */
public class Language extends AbstractModel {

    private String language;
    private Official isOfficial;
    private float percentage;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Official getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Official isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    enum Official {
        T,
        F
    }
}
