package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp =  new BibliotecaApp();
        bibliotecaApp.showWelcomeMessage();

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", "November 4, 2004"));
        books.add(new Book("Clean Code", "Robert C. Martin ", "August 11, 2008"));
        books.add(new Book("Programming in Scala", "Martin Odersky", "January 4, 2011"));
        books.add(new Book("Head First Java", "Kathy Sierra", "February 9, 2005"));
        books.add(new Book("JavaScript: The Good Parts", "Douglas Crockford", "May, 2008"));

        Library library = new Library(books);
        bibliotecaApp.showBooksOfLibrary(library.getBooks());
    }

    public void showWelcomeMessage() {

        String welcomeMessage = "----- WELCOME TO BIBLIOTECA -----\n";
        System.out.println(welcomeMessage);
    }

    public void showBooksOfLibrary(List<Book> books) {

        System.out.println("----- BOOK LIST OF BIBLIOTECA -----\n");

        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " BookName: " + books.get(i).getName() +
                    ", Author: " + books.get(i).getAuthor() + ", Publish Date: " +
                    books.get(i).getPublishedDate());
        }
    }

}
