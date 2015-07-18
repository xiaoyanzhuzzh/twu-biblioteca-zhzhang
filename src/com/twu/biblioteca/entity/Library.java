package com.twu.biblioteca.entity;

import java.util.List;

public class Library {
    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
