package com.twu.biblioteca.entity;

import java.util.List;

public class Library {

    private List<Book> books;
    private List<User> users;

    public Library() {

    }

    public Library(List<Book> books) {
        this.books = books;
    }

    public Library(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
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
