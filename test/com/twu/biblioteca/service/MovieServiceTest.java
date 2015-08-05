package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {
    private MovieService movieService;

    @Before
    public void initMovieService() {

        movieService = new MovieService();
    }

    @Test
    public void canInitMoviesTest() {

        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        assertEquals(movie.getName(), movieService.initMovies().get(0).getName());
        assertEquals(movie.getDirector(), movieService.initMovies().get(0).getDirector());
        assertEquals(movie.getRating(), movieService.initMovies().get(0).getRating());
    }

    @Test
    public void canShowWelcomeMessageTest() {

        String welcomeMessage = "----------   WELCOME TO MOVIE LIBRARY   ----------";
        assertEquals(welcomeMessage, movieService.showWelcomeMessage());
    }

    @Test
    public void canShowMainMenuForCustomerTest() {

        String result = "----------   Main Menu of Movie Library ----------\n" +
                "\n[0] Exit Movie Library\n" +
                "[1] List Movies of Library\n" +
                "[2] Check Out Movie\n" +
                "[3] Return Movie\n" +
                "\nPlease Enter Your Choice :";
        assertEquals(result, movieService.showMoviesMenuForCustomer());
    }

    @Test
    public void canGetAvailableMovies() {

        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);

        assertEquals(1, movieService.getAvailableMovies(movies).size());

        movie.setIsBorrowed(true);
        assertEquals(0, movieService.getAvailableMovies(movies).size());
    }


    @Test
    public void canShowMoviesOfLibraryTest() {

        String moviesOfLibrary = "----------   MOVIE LIST OF BIBLIOTECA   ----------\n";

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "The Social Network", "2010", "David Fincher", 8));
        movies.add(new Movie(2, "Pirates of Silicon Valley", "1999", "Martyn Burke", 8));
        movies.add(new Movie(3, "Steve Jobs - One Last Thing", "2011", "Mimi O'Connor", 9));
        movies.add(new Movie(4, "The Matrix", "1999", "Andy Wachowski & Lana Wachowski", 9));

        for(int i = 0; i < movieService.getAvailableMovies(movies).size(); i++) {
            moviesOfLibrary += movieService.getAvailableMovies(movies).get(i).getMovieInfo();
        }
        assertEquals(moviesOfLibrary, movieService.showMoviesOfLibrary(movieService.getAvailableMovies(movies)));
    }

    @Test
    public void canCheckOutBookTest() {

        User user = new User("zhzhang", "1111", "customer");
        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        movieService.checkOutMovie(movie, user);

        assertEquals(1, user.getBorrowedMovies().size());
        assertEquals(movie.getName(), user.getBorrowedMovies().get(0).getName());
    }

    @Test
    public void canReturnBookTest() {

        User user = initUserWithBorrowedMovies();

        movieService.returnMovies(user.getBorrowedMovies().get(0), user);
        assertEquals(0, user.getBorrowedMovies().size());
    }

    private User initUserWithBorrowedMovies() {

        User user = new User("zhzhang", "1111", "customer");

        List<Movie> borrowedMovies = new ArrayList<Movie>();
        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        movie.setIsBorrowed(true);

        borrowedMovies.add(movie);

        user.setBorrowedMovies(borrowedMovies);
        return user;
    }
}

