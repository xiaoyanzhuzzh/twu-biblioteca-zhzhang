package com.twu.biblioteca.entity;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
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
    public void initLibraryWithBooksAndUsersAndMovies() {

        BookService libraryService = new BookService();
        MovieService movieService = new MovieService();
        Library currentLibrary = new Library(libraryService, movieService);

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book(2, "Head First Design Patterns", "Eric Freeman", "November 4, 2004"));
        books.add(new Book(3, "Clean Code", "Robert C. Martin ", "August 11, 2008"));
        books.add(new Book(4, "Programming in Scala", "Martin Odersky", "January 4, 2011"));
        books.add(new Book(5, "Head First Java", "Kathy Sierra", "February 9, 2005"));
        books.add(new Book(6, "JavaScript: The Good Parts", "Douglas Crockford", "May, 2008"));

        assertEquals(books.get(0).getAuthor(), currentLibrary.getBooks().get(0).getAuthor());

        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        assertEquals(users.get(0).getName(), currentLibrary.getUsers().get(0).getName());

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "The Social Network", "2010", "David Fincher", 8));
        movies.add(new Movie(2, "Pirates of Silicon Valley", "1999", "Martyn Burke", 8));
        movies.add(new Movie(3, "Steve Jobs - One Last Thing", "2011", "Mimi O'Connor", 9));
        movies.add(new Movie(4, "The Matrix", "1999", "Andy Wachowski & Lana Wachowski", 9));

        assertEquals(movies.get(0).getName(), currentLibrary.getMovies().get(0).getName());

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
