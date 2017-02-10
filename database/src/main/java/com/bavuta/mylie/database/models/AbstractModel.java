package com.bavuta.mylie.database.models;

/**
 * Created by bogdan on 11/4/2016.
 */
public abstract class AbstractModel {

    private Long id;
    private Long createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
