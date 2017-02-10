package com.bavuta.mylie.ws.dto;

/**
 * Created by bogdan on 12/19/2016.
 */
public class UserDTO extends AbstractDTO {

    private String email;
    private String password;

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
