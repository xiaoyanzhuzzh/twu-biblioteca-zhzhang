package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;

    @Before
    public void initLibrary() {
        library = new Library();
    }

    @Test
    public void canSetBooksTest() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        library.setBooks(books);
        assertEquals(books, library.getBooks());
    }

    @Test
    public void canSetUsersTest() {
        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        library.setUsers(users);
        assertEquals(users, library.getUsers());
    }
}
