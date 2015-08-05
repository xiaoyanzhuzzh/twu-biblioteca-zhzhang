package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public List<Movie> initMovies() {

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "The Social Network", "2010", "David Fincher", 8));
        movies.add(new Movie(2, "Pirates of Silicon Valley", "1999", "Martyn Burke", 8));
        movies.add(new Movie(3, "Steve Jobs - One Last Thing", "2011", "Mimi O'Connor", 9));
        movies.add(new Movie(4, "The Matrix", "1999", "Andy Wachowski & Lana Wachowski", 9));

        return movies;
    }


}
