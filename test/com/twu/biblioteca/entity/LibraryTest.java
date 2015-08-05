package com.twu.biblioteca.entity;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
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
    public void constructorTest() {

        BookService bookService = new BookService();
        MovieService movieService = new MovieService();
        UserService userService = new UserService();

        Library currentLibrary = new Library(bookService, movieService, userService);

        Book book = new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        assertEquals(book.getAuthor(), currentLibrary.getBooks().get(0).getAuthor());

        User user = new User("zhzhang", "1111", "customer");
        assertEquals(user.getName(), currentLibrary.getUsers().get(0).getName());

        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        assertEquals(movie.getName(), currentLibrary.getMovies().get(0).getName());

    }
    @Test
    public void canSetBooksTest() {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));

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

    @Test
    public void canSetMoviesTest() {

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "The Social Network", "2010", "David Fincher", 8));
        movies.add(new Movie(2, "Pirates of Silicon Valley", "1999", "Martyn Burke", 8));

        library.setMovies(movies);
        assertEquals(movies, library.getMovies());
    }
}
