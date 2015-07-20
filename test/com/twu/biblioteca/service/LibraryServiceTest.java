package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
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
    public void canInitUsersTest() {

        User user = new User("zhzhang", "1111", "customer");
        assertEquals(user.getName(), libraryService.initUsers().get(0).getName());
        assertEquals(user.getPassword(), libraryService.initUsers().get(0).getPassword());
    }

    @Test
    public void canInitBooksTest() {

        Book book = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        assertEquals(book.getName(), libraryService.initBooks().get(0).getName());
        assertEquals(book.getAuthor(), libraryService.initBooks().get(0).getAuthor());
    }

    @Test
    public void canShowWelcomeMessageTest() {

        String welcomeMessage = "----------   WELCOME TO BIBLIOTECA   ----------";
        assertEquals(welcomeMessage, libraryService.showWelcomeMessage());
    }

    @Test
    public void canShowMainMenuForCustomerTest() {

        String welcomeMessage = "----------   Main  Menu   ----------\n" +
                                "\n[0] Exit BIBLIOTECA\n" +
                                "[1] List Books of Library\n" +
                                "[2] Check Out Book\n" +
                                "[3] Return Book\n" +
                                "\nPlease Enter Your Choice :";
        assertEquals(welcomeMessage, libraryService.showMainMenuForCustomer());
    }

    @Test
    public void canShowBooksOfLibraryTest() {

        Library library = new Library(libraryService);
        libraryService.showBooksOfLibrary(library);
    }

//    @Test
//    public void canCheckOutBookTest() {
//
//        libraryService.checkOutBook();
//    }
}
