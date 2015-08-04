package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Movie movie;

    @Before
    public void initUser() {
        movie = new Movie();
    }

    @Test
    public void canSetMovieIdTest() {

        movie.setId(1);
        assertEquals(1, movie.getId());
    }

    @Test
    public void canSetMovieNameTest() {

        movie.setName("The Social Network");
        assertEquals("The Social Network", movie.getName());
    }

    @Test
    public void canSetMovieYearTest() {

        movie.setYear("2000");
        assertEquals("2000", movie.getYear());
    }

    @Test
    public void canSetMovieDirectorTest() {

        movie.setDirector("David Fincher");
        assertEquals("David Fincher", movie.getDirector());
    }

    @Test
    public void canSetMovieRatingTest() {

        movie.setRating(8);
        assertEquals(8, movie.getRating());
    }
 }
