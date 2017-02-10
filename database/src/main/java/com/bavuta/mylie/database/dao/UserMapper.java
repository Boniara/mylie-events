package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.User;

import java.util.List;

/**
 * Created by bogdan on 11/4/2016.
 */

public interface UserMapper {

    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    Long createUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
}
