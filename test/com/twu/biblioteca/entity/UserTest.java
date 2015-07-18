package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void initUser() {
        user = new User();
    }

    @Test
    public void canSetUserNameTest() {
        user.setName("zhzhang");
        assertEquals("zhzhang", user.getName());
    }

    @Test
    public void canSetUserPasswordTest() {
        user.setPassword("1111");
        assertEquals("1111", user.getPassword());
    }

    @Test
    public void canSetUserTypeTest() {
        user.setType("customer");
        assertEquals("customer", user.getType());
    }

    @Test
    public void constructorTest() {
        user = new User("zhzhang", "1111", "customer");
        assertEquals("zhzhang", user.getName());
        assertEquals("1111", user.getPassword());
        assertEquals("customer", user.getType());
    }
}
