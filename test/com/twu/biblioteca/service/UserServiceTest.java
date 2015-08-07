package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void canGetCustomersWithBorrowedBooksTest() {

        User user = new User("zhzhang", "1111", "customer");

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999", true));
        books.add(new Book(2, "Head First Design Patterns", "Eric Freeman", "November 4, 2004", true));

        user.setBorrowedBooks(books);

        List<User> users = new ArrayList<User>();
        users.add(new User("zzh", "1111", "customer"));
        users.add(user);

        assertEquals(user.getName(), userService.getCustomersWithBorrowedBooks(users).get(0).getName());
    }

    @Test
    public void canGetCustomersWithBorrowedMoviesTest() {

        User user = new User("zhzhang", "1111", "customer");

        List<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie(2, "Pirates of Silicon Valley", "1999", "Martyn Burke", 8, true));
        movies.add(new Movie(3, "Steve Jobs - One Last Thing", "2011", "Mimi O'Connor", 9, true));
        movies.add(new Movie(4, "The Matrix", "1999", "Andy Wachowski & Lana Wachowski", 9, true));

        user.setBorrowedMovies(movies);

        List<User> users = new ArrayList<User>();
        users.add(new User("zzh", "1111", "customer"));
        users.add(user);

        assertEquals(user.getName(), userService.getCustomersWithBorrowedMovies(users).get(0).getName());

    }
}
