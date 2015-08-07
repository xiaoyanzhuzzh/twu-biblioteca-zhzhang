package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void canSetUserEmailTest() {

        user.setEmail("zhzhang@163.com");
        assertEquals("zhzhang@163.com", user.getEmail());
    }

    @Test
    public void canSetUserPhoneNumberTest() {

        user.setPhoneNumber("18729591184");
        assertEquals("18729591184", user.getPhoneNumber());
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
    public void canSetUserBorrowBooksTest() {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        user.setBorrowedBooks(books);
        assertEquals(books, user.getBorrowedBooks());
    }

    @Test
    public void constructorTest() {

        user = new User("zhzhang", "1111", "customer", "zhzhang@163.com", "18729591184");
        assertEquals("zhzhang", user.getName());
        assertEquals("1111", user.getPassword());
        assertEquals("customer", user.getType());
    }
}
