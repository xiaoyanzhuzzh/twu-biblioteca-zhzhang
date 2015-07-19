package com.twu.biblioteca.helper;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryHelperTest {

    private Libraryhelper libraryHelper;

    @Before
    public void initLibraryHelper() {

        libraryHelper = new Libraryhelper();
    }

    @Test
    public void initLibraryTest() {

        User user = new User("zhzhang", "1111", "customer");
        assertEquals(user.getName(), libraryHelper.initLibrary().getUsers().get(0).getName());
        assertEquals(user.getPassword(), libraryHelper.initLibrary().getUsers().get(0).getPassword());

        Book book = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        assertEquals(book.getName(), libraryHelper.initLibrary().getBooks().get(0).getName());
        assertEquals(book.getAuthor(), libraryHelper.initLibrary().getBooks().get(0).getAuthor());

    }

    @Test
    public void canShowWelcomeMessageTest() {

        String welcomeMessage = "----- WELCOME TO BIBLIOTECA -----\n";
        assertEquals(welcomeMessage, libraryHelper.showWelcomeMessage());
    }
}
