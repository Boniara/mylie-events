package com.bavuta.mylie;

import com.bavuta.mylie.database.dao.RoleMapper;
import com.bavuta.mylie.database.dao.UserMapper;
import com.bavuta.mylie.database.models.Role;
import com.bavuta.mylie.database.models.User;
import com.bavuta.mylie.database.models.UserRole;
import com.bavuta.mylie.database.utils.KeyGenerator;
import com.bavuta.mylie.utils.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static com.bavuta.mylie.database.models.Gender.FEMALE;
import static com.bavuta.mylie.database.models.Gender.MALE;

/**
 * Created by bogdan on 11/5/2016.
 */

@Test
@ContextConfiguration("classpath:com/bavuta/mylie/database/test-dbaccess.xml")
public class UserTests extends AbstractTestNGSpringContextTests {

    private static KeyGenerator generator = new KeyGenerator();

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    private static final User USER = new User() {
        private static final long serialVersionUID = 1L;
        {
            Calendar calendar = Calendar.getInstance();
            UserRole userRole = new UserRole();
            List<UserRole> userRoleList = new ArrayList<>();
            userRoleList.add(userRole);
            userRole.setRole(Role.USER);
            userRole.setId(1L);
            calendar.set(1980, 01, 01);
            setId(0L);
            setName("n1");
            setEmail("my_email" + generator.getNewKey() + "@gmail.com");
            setUserRoleList(userRoleList);
            setPassword("qwerty1234asd");
            setDateOfBirth(calendar.getTime());
            setGender(MALE);
            setAbout("My name is Cool");
            setPriority(10);
        }
    };

    @Test
    public void createUserTest() {
        userMapper.createUser(USER);
        roleMapper.addRoleToUser(USER, USER.getUserRoleList().get(0));
        Assert.assertNotEquals(USER.getId(), null, "");
    }

    @Test(dependsOnMethods = {"createUserTest"})
    public void getAllUsersTest() {
        List<User> userList = userMapper.getAllUsers();
        Collections.sort(userList, new Sort());
        checkUser(userList.get(userList.size() - 1));
    }

    @Test(dependsOnMethods = {"createUserTest"})
    public void getUserByIdTest() {
        User user = userMapper.getUserById(USER.getId());
        checkUser(user);
    }

    @Test(dependsOnMethods = {"createUserTest"})
    public void updateUserTest() {
        USER.setName("n2");
        USER.setEmail("my_email" + generator.getNewKey() + "@gmail.com");
        USER.setPassword("qwertyasd1234");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1981, 01, 01);
        USER.setDateOfBirth(calendar.getTime());
        USER.setGender(FEMALE);
        USER.setAbout("My name super cool");
        USER.setPriority(12);
        userMapper.updateUser(USER);
        checkUser(userMapper.getUserById(USER.getId()));
    }

    @Test(dependsOnMethods = {"createUserTest", "updateUserTest"})
    public void deleteUserByIdTest() {
        userMapper.deleteUserById(USER.getId());
        Assert.assertNull(userMapper.getUserById(USER.getId()));
    }

    private void checkUser(User user) {
        Assert.assertEquals(USER.getId(), user.getId(), "");
        Assert.assertEquals(USER.getName(), user.getName(), "");
        Assert.assertEquals(USER.getEmail(), user.getEmail(), "");
        Assert.assertEquals(USER.getPassword(), user.getPassword(), "");
        Assert.assertEquals(USER.getDateOfBirth().getYear(), user.getDateOfBirth().getYear(), "");
        Assert.assertEquals(USER.getDateOfBirth().getMonth(), user.getDateOfBirth().getMonth(), "");
        Assert.assertEquals(USER.getDateOfBirth().getDate(), user.getDateOfBirth().getDate(), "");
        Assert.assertEquals(USER.getGender(), user.getGender(), "");
        Assert.assertEquals(USER.getAbout(), user.getAbout(), "");
        Assert.assertEquals(USER.getPriority(), user.getPriority(), "");
    }
}
