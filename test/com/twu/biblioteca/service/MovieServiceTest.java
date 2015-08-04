package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {
    private MovieService movieService;

    @Before
    public void initLibraryService() {

        movieService = new MovieService();
    }

    @Test
    public void canInitMoviesTest() {

        Movie movie = new Movie(1, "The Social Network", "2010", "David Fincher", 8);
        assertEquals(movie.getName(), movieService.initMovies().get(0).getName());
        assertEquals(movie.getDirector(), movieService.initMovies().get(0).getDirector());
        assertEquals(movie.getRating(), movieService.initMovies().get(0).getRating());
    }

}

