package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {

    private LibraryService libraryService;

    @Before
    public void initLibraryService() {

        libraryService = new LibraryService();
    }

    @Test
    public void canInitLibraryTest() {
        User user = new User("zhzhang", "1111", "customer");
        assertEquals(user.getName(), libraryService.initLibrary().getUsers().get(0).getName());
        assertEquals(user.getPassword(), libraryService.initLibrary().getUsers().get(0).getPassword());

        Book book = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        assertEquals(book.getName(), libraryService.initLibrary().getBooks().get(0).getName());
        assertEquals(book.getAuthor(), libraryService.initLibrary().getBooks().get(0).getAuthor());
    }
}
