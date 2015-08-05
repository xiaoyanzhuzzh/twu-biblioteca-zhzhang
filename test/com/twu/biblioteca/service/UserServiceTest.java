package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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

    @Test
    public void canUserLoginTest() {

        User user = new User("zhzhang", "1111", "customer");

        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        assertEquals(user, userService.userLogin(user, users));
    }

    @Test
    public void canShowCustomerInformationTest() {

        User customer = new User("zhzhang", "1111", "customer");

        String customerInformation = "Name: " + customer.getName() + "\n" +
                                     "Email: \n" +
                                     "PhoneNumber: \n";
        assertEquals(customerInformation, userService.showCustomerInformation(customer));
    }
}
