package com.twu.biblioteca.entity;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<Book>();
    private List<User> users = new ArrayList<User>();
    private List<Movie> movies = new ArrayList<Movie>();

    public Library() {

    }

    public Library(BookService bookService, MovieService movieService) {

        this.books = bookService.initBooks();
        this.users = bookService.initUsers();
        this.movies = movieService.initMovies();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                ", movies=" + movies +
                '}';
    }
}
