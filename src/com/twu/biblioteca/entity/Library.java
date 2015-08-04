package com.twu.biblioteca.entity;

import com.twu.biblioteca.service.BookService;

import java.util.List;

public class Library {

    private List<Book> books;
    private List<User> users;

    public Library() {

    }

    public Library(BookService libraryService) {

        this.books = libraryService.initBooks();
        this.users = libraryService.initUsers();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }
}
