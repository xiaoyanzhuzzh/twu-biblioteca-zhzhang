package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private String type;
    private List<Book> borrowedBooks = new ArrayList<Book>();

    public User() {

    }

    public User(String name, String password, String type) {
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
