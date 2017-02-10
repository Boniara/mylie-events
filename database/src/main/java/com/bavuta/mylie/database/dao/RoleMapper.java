package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.User;
import com.bavuta.mylie.database.models.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * Created by bogdan on 12/29/2016.
 */
public interface RoleMapper {

    void addRoleToUser(@Param("user") User user, @Param("role") UserRole userRole);
}
