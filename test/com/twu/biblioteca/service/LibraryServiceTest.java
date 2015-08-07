package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
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
    public void canShowWelcomeMessageTest() {

        String welcomeMessage = "----------   WELCOME TO BIBLIOTECA   ----------";
        assertEquals(welcomeMessage, libraryService.showWelcomeMessage());
    }

    @Test
    public void canShowMainMenuForCustomerTest() {
        String welcomeMessage = "----------   Main  Menu of BIBLIOTECA  ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] List Books of Library\n" +
                "[2] List Movies of Library\n" +
                "[3] Show Your Own Information\n" +
                "\nPlease Enter Your Choice :";
        assertEquals(welcomeMessage, libraryService.showMainMenuForCustomer());
    }

    @Test
    public void canShowMainMenuForLibrarianTest() {
        String welcomeMessage = "----------   Main  Menu of BIBLIOTECA  ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] Enter Book Library\n" +
                "[2] Enter Movie Library\n" +
                "[3] Show Who Borrow Book & Movie\n" +
                "\nPlease Enter Your Choice :";
        assertEquals(welcomeMessage, libraryService.showMainMenuForLibrarian());
    }

    @Test
    public void canShowCustomersWithBorrowedBooksTest() {

        List<User> users = new ArrayList<User>();

        User user = new User("zhzhang", "1111", "customer", "zhznag@163.com", "18729591184");

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999", true));
        books.add(new Book(2, "Head First Design Patterns", "Eric Freeman", "November 4, 2004", true));

        user.setBorrowedBooks(books);

        users.add(user);

        String result = "\n----------   Who Borrow Books?   ----------\n";
        result += "Customer: " + user.getName() + "\n";
        for(Book book: books) {
            result += book.getBookInfo();
        }
        System.out.println(result);
        assertEquals(result, libraryService.showCustomersWithBorrowedBooks(users));
    }

    @Test
    public void canShowCustomersWithBorrowedMoviesTest() {

        List<User> users = new ArrayList<User>();

        User user = new User("zhzhang", "1111", "customer", "zhznag@163.com", "18729591184");

        List<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie(2, "Pirates of Silicon Valley", "1999", "Martyn Burke", 8, true));
        movies.add(new Movie(3, "Steve Jobs - One Last Thing", "2011", "Mimi O'Connor", 9, true));
        movies.add(new Movie(4, "The Matrix", "1999", "Andy Wachowski & Lana Wachowski", 9, true));

        user.setBorrowedMovies(movies);
        users.add(user);

        String result = "\n----------   Who Borrow Movies?   ----------\n";
        result += "Customer: " + user.getName() + "\n";
        for(Movie movie: movies) {
            result += movie.getMovieInfo();
        }
        System.out.println(result);
        assertEquals(result, libraryService.showCustomersWithBorrowedMovies(users));
    }
}
