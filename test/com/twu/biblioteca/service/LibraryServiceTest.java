package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void canShowWelcomeMessageTest() {

        String welcomeMessage = "----- WELCOME TO BIBLIOTECA -----\n";
        assertEquals(welcomeMessage, libraryService.showWelcomeMessage());
    }

    @Test
    public void canShowMainMenuForCustomer() {

        String welcomeMessage = "---------- Main  Menu ----------\n" +
                                "\n[0] Exit BIBLIOTECA\n" +
                                "[1] List Books of Library\n" +
                                "[2] Check Out Book\n" +
                                "[3] Return Book\n" +
                                "\nPlease Enter Your Choice :";
        assertEquals(welcomeMessage, libraryService.showMainMenuForCustomer());
    }

    @Test
    public void canShowBooksOfLibrary() {

        List<Book> books = new ArrayList<Book>();
        libraryService.showBooksOfLibrary(books);
    }
}
