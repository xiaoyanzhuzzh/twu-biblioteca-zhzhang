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
    public void canSetMovieNameTest() {

        movie.setName("The Social Network");
        assertEquals("The Social Network", movie.getName());
    }
}
