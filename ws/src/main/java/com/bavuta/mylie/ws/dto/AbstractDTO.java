package com.bavuta.mylie.ws.dto;

/**
 * Created by bogdan on 12/19/2016.
 */
public abstract class AbstractDTO {

    private long id;

    public AbstractDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
