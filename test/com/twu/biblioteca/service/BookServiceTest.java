package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookServiceTest {

    private BookService bookService;

    @Before
    public void initLibraryService() {

        bookService = new BookService();
    }

    @Test
    public void canInitBooksTest() {

        Book book = new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        assertEquals(book.getName(), bookService.initBooks().get(0).getName());
        assertEquals(book.getAuthor(), bookService.initBooks().get(0).getAuthor());
    }

    @Test
    public void canShowWelcomeMessageTest() {

        String welcomeMessage = "----------   WELCOME TO BIBLIOTECA   ----------";
        assertEquals(welcomeMessage, bookService.showWelcomeMessage());
    }

    @Test
    public void canShowMainMenuForCustomerTest() {

        String welcomeMessage = "----------   Main  Menu  of Book Library ----------\n" +
                "\n[0] Exit Book Library\n" +
                "[1] List Books of Library\n" +
                "[2] Check Out Book\n" +
                "[3] Return Book\n" +
                "\nPlease Enter Your Choice :";
        assertEquals(welcomeMessage, bookService.showMainMenuForCustomer());
    }

    @Test
    public void canGetAvailableBooks() {

        Book book = new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        List<Book> books = new ArrayList<Book>();
        books.add(book);

        assertEquals(1, bookService.getAvailableBooks(books).size());

        book.setIsBorrowed(true);
        assertEquals(0, bookService.getAvailableBooks(books).size());
    }

    @Test
    public void canShowBooksOfLibraryTest() {

        String booksOfLibrary = "----------   BOOK LIST OF BIBLIOTECA   ----------\n";

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book(2, "Programming in Scala", "Martin Odersky", "January 4, 2011"));

        for(int i = 0; i < bookService.getAvailableBooks(books).size(); i++) {
            booksOfLibrary += bookService.getAvailableBooks(books).get(i).getBookInfo();
        }
        assertEquals(booksOfLibrary, bookService.showBooksOfLibrary(bookService.getAvailableBooks(books)));
    }

    @Test
    public void canCheckOutBookTest() {

        User user = new User("zhzhang", "1111", "customer");
        Book book = new Book(1, "Programming in Scala", "Martin Odersky", "January 4, 2011");

        bookService.checkOutBook(book, user);

        assertEquals(1, user.getBorrowedBooks().size());
        assertEquals(book.getName(), user.getBorrowedBooks().get(0).getName());
    }

    @Test
    public void canReturnBookTest() {

        User user = initUserWithBorrowedBooks();

        bookService.returnBooks(user.getBorrowedBooks().get(0), user);
        assertEquals(0, user.getBorrowedBooks().size());
    }

    private User initUserWithBorrowedBooks() {

        User user = new User("zhzhang", "1111", "customer");

        List<Book> borrowedBooks = new ArrayList<Book>();
        Book book = new Book(1, "Programming in Scala", "Martin Odersky", "January 4, 2011", true);
        borrowedBooks.add(book);

        user.setBorrowedBooks(borrowedBooks);
        return user;
    }
}

