package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class UserServiceTest {

    private UserService userService;

    @Before
    public void initUserService() {
        userService = new UserService();
    }

    @Test
    public void canInitUsersTest() {
        User user = new User("zhzhang", "1111", "customer");
        assertEquals(user.getName(), userService.initUsers().get(0).getName());
    }
}
