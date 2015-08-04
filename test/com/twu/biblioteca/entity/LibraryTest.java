package com.twu.biblioteca.entity;

import com.twu.biblioteca.service.LibraryService;
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
    public void initLibraryWithBooksAndUsers() {

        LibraryService libraryService = new LibraryService();
        Library currentLibrary = new Library(libraryService);

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", "November 4, 2004"));
        books.add(new Book("Clean Code", "Robert C. Martin ", "August 11, 2008"));
        books.add(new Book("Programming in Scala", "Martin Odersky", "January 4, 2011"));
        books.add(new Book("Head First Java", "Kathy Sierra", "February 9, 2005"));
        books.add(new Book("JavaScript: The Good Parts", "Douglas Crockford", "May, 2008"));

        assertEquals(books.get(0).getAuthor(), currentLibrary.getBooks().get(0).getAuthor());

        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        assertEquals(users.get(0).getName(), currentLibrary.getUsers().get(0).getName());
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
