package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;

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


    public String showMoviesOfLibrary(List<Movie> movies) {

        List<Movie> movieList = this.getAvailableMovies(movies);
        String moviesOfLibrary = "----------   MOVIE LIST OF BIBLIOTECA   ----------\n";

        for (int i = 0; i < movieList.size(); i++) {
            moviesOfLibrary += movieList.get(i).getMovieInfo();
        }

        return moviesOfLibrary;
    }

    public void checkOutMovie(Movie movie, User user) {

        movie.setIsBorrowed(true);

        List<Movie> borrowedMovies = new ArrayList<Movie>();
        borrowedMovies.add(movie);

        user.setBorrowedMovies(borrowedMovies);

        System.out.println("Thank you! Enjoy the Movie!");
    }

    public void showCheckOutMoviesMenu(Library library, User user) {

        List<Movie> movies = this.getAvailableMovies(library.getMovies());
        System.out.println(this.showMoviesOfLibrary(movies));

        System.out.println("Please Enter the Movie Number You Want to Check Out:");
        int checkOutNumber = Integer.parseInt(InputReaderHelper.getInput());

        try {

            this.checkOutMovie(this.getMovieById(checkOutNumber, movies), user);
        } catch (Exception e) {

            System.out.println("\n----------   Select A Valid Option!   ----------\n");
            e.getMessage();
        }
    }

    public void returnMovies(Movie movie, User user) {

        movie.setIsBorrowed(false);
        List<Movie> borrowedMovies = user.getBorrowedMovies();
        borrowedMovies.remove(movie);
        System.out.println("Thank you for returning the movie!");
    }

    public void showReturnMoviesMenu(User user) {

        List<Movie> movies = user.getBorrowedMovies();
        String returnMoviesMenu = "----------   BORROWED MOVIE LIST   ----------\n";

        for (int i = 0; i < movies.size(); i++) {
            returnMoviesMenu += movies.get(i).getMovieInfo();
        }

        returnMoviesMenu += "Please Enter the Book Number You Want to Return:";
        System.out.println(returnMoviesMenu);
        int returnNumber = Integer.parseInt(InputReaderHelper.getInput());

        try {

            this.returnMovies(this.getMovieById(returnNumber, movies), user);
        } catch (Exception e) {

            System.out.println("\nSelect A Valid Option!\n");
            e.getMessage();
        }
    }

    private Movie getMovieById(int id, List<Movie> movies) {

        Movie result = null;
        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId() == id) {
                result =  movies.get(i);
            }
        }
        return result;
    }

}
