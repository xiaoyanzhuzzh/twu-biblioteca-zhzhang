package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    public Library initLibrary() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", "November 4, 2004"));
        books.add(new Book("Clean Code", "Robert C. Martin ", "August 11, 2008"));
        books.add(new Book("Programming in Scala", "Martin Odersky", "January 4, 2011"));
        books.add(new Book("Head First Java", "Kathy Sierra", "February 9, 2005"));
        books.add(new Book("JavaScript: The Good Parts", "Douglas Crockford", "May, 2008"));

        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        return new Library(books, users);
    }

    public String showWelcomeMessage() {
        return "----- WELCOME TO BIBLIOTECA -----\n";
    }
}
