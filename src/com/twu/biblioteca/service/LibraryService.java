package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    public List<User> initUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        return users;
    }

    public List<Book> initBooks() {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", "November 4, 2004"));
        books.add(new Book("Clean Code", "Robert C. Martin ", "August 11, 2008"));
        books.add(new Book("Programming in Scala", "Martin Odersky", "January 4, 2011"));
        books.add(new Book("Head First Java", "Kathy Sierra", "February 9, 2005"));
        books.add(new Book("JavaScript: The Good Parts", "Douglas Crockford", "May, 2008"));

        return books;
    }

    public String showWelcomeMessage() {
        return "----- WELCOME TO BIBLIOTECA -----\n";
    }

    public String showMainMenuForCustomer() {

        return "---------- Main  Menu ----------\n" +
                "\n[0] Exit BIBLIOTECA\n" +
                "[1] List Books of Library\n" +
                "[2] Check Out Book\n" +
                "[3] Return Book\n" +
                "\nPlease Enter Your Choice :";
    }

    public void showBooksOfLibrary(List<Book> books) {
        System.out.println("---------- BOOK LIST OF BIBLIOTECA ----------\n");

        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " BookName: " + books.get(i).getName() +
                    ", Author: " + books.get(i).getAuthor() + ", Publish Date: " +
                    books.get(i).getPublishedDate());
        }
        System.out.println();
    }

    public void checkOutBook(Library library) {

        List<Book> books = this.getAvailableBooks(library);
        this.showBooksOfLibrary(books);

        System.out.println("Please Enter the Book Number You Want to Check Out:");
        int checkOutNumber = Integer.parseInt(InputReaderHelper.getInput());

        if(checkOutNumber < 0 && checkOutNumber > books.size()) {

            System.out.println("\nSelect A Valid Option!\n");
        } else {

            System.out.println(checkOutNumber - 1);
            books.get(checkOutNumber -1).setIsBorrowed(true);

            System.out.println(books.get(checkOutNumber - 1).getIsBorrowed());
            System.out.println(this.getAvailableBooks(library).size());

            List<Book> returnBooks = new ArrayList<Book>();
            returnBooks.add(books.get(checkOutNumber));
            System.out.println("Thank you! Enjoy the book");
        }
    }

    public List<Book> getAvailableBooks(Library library) {

        List<Book> availableBooks = new ArrayList<Book>();
        for(Book book: library.getBooks()) {

            if(!book.getIsBorrowed()) {

                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

//    public void CheckOutBook() {
//
//        bookLibrary.listBooks(bookLibrary.getAvailableBooks());
//        System.out.println("Please input one number that you want to checkout :");
//        int checkoutNumber = Integer.parseInt(InputReader.getInput());
//
//        try {
//            Book checkoutBook = bookLibrary.getAvailableBooks().get(checkoutNumber - 1);
//            bookLibrary.getAvailableBooks().remove(checkoutNumber - 1);
//            bookLibrary.setBorrowedBook(checkoutNumber);
//            checkoutBook.setUser(user);
//            System.out.println("Thank you! Enjoy the book");
//        } catch (Exception e) {
//            System.out.println("That book is not available");
//            e.getMessage();
//        }
//    }
}
