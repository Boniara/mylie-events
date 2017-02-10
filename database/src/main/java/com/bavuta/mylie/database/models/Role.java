package com.bavuta.mylie.database.models;

/**
 * Created by bogdan on 12/27/2016.
 */
public enum Role {

    USER("USER"),
    ADMIN("ADMIN");

    private String permission;

    Role(String userPermission) {
        this.permission = userPermission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
