package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void canGetAvailableBooks() {

        Book book = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        List<Book> books = new ArrayList<Book>();
        books.add(book);

        assertEquals(1, libraryService.getAvailableBooks(books).size());

        book.setIsBorrowed(true);
        assertEquals(0, libraryService.getAvailableBooks(books).size());
    }

    @Test
    public void canShowBooksOfLibraryTest() {
        String booksOfLibrary = "----------   BOOK LIST OF BIBLIOTECA   ----------\n";

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book("Programming in Scala", "Martin Odersky", "January 4, 2011"));

            for(int i = 0; i < libraryService.getAvailableBooks(books).size(); i++) {
                booksOfLibrary += "[" + (i + 1) + "] " + libraryService.getAvailableBooks(books).get(i).getBookInfo();
            }
            assertEquals(booksOfLibrary, libraryService.showBooksOfLibrary(libraryService.getAvailableBooks(books)));
        }

    }





//    @Test
//    public void canShowBooksOfLibraryTest() {
//
//        Library library = new Library(libraryService);
////        libraryService.showBooksOfLibrary(library);
//    }

//    @Test
//    public void canCheckOutBookTest() {
//
//        libraryService.checkOutBook();
//    }
//}
