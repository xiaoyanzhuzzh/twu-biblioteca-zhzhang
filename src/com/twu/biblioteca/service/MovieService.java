package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.BitSet;
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

    public String showWelcomeMessage() {
        return "----------   WELCOME TO MOVIE LIBRARY   ----------";
    }

    public String showMoviesMenuForCustomer() {
        return "----------   Main Menu of Movie Library ----------\n" +
                "\n[0] Exit Movie Library\n" +
                "[1] List Movies of Library\n" +
                "[2] Check Out Movie\n" +
                "[3] Return Movie\n" +
                "\nPlease Enter Your Choice :";
    }

    public List<Movie> getAvailableMovies(List<Movie> movies) {
        
        List<Movie> availableMovies = new ArrayList<Movie>();
        for(Movie movie: movies) {

            if(!movie.getIsBorrowed()) {

                availableMovies.add(movie);
            }
        }

        return availableMovies;
    }
}
