package com.bavuta.mylie.database.models;

/**
 * Created by bogdan on 12/27/2016.
 */
public class UserRole extends AbstractModel {

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role.getPermission();
    }
}
