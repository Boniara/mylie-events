package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.RoleMapper;
import com.bavuta.mylie.database.dao.UserMapper;
import com.bavuta.mylie.database.models.User;
import com.bavuta.mylie.database.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user) {
        userMapper.createUser(user);
        for(UserRole userRole: user.getUserRoleList()) {
            roleMapper.addRoleToUser(user, userRole);
        }
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public User getUserById(Long id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<User> getAllUseres() {
        List<User> userList = userMapper.getAllUsers();
        return userList;
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) {
        userMapper.updateUser(user);
        User updatingUser = userMapper.getUserById(user.getId());
        return updatingUser;
    }

    @Transactional(rollbackFor = Exception.class)
    public User deleteUserById(Long id) {
        User user = userMapper.getUserById(id);
        userMapper.deleteUserById(id);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userMapper.getUserByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException("User with email '" + email + "' does not exists");
        return user;
    }
}
