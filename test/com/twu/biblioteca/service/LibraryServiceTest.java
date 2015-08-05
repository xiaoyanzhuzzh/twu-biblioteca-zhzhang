package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.Movie;
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

        Library library = new Library();

        User user = new User("zhzhang", "1111", "customer");
        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        Book book = new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");

        libraryService.initLibrary();

        assertEquals(user.getName(), library.getUsers().get(0).getName());
        assertEquals(book.getName(), library.getBooks().get(0).getName());
        assertEquals(movie.getName(), library.getMovies().get(0).getName());
    }

}
