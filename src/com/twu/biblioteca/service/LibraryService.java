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
        books.add(new Book(1, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999"));
        books.add(new Book(2, "Head First Design Patterns", "Eric Freeman", "November 4, 2004"));
        books.add(new Book(3, "Clean Code", "Robert C. Martin ", "August 11, 2008"));
        books.add(new Book(4, "Programming in Scala", "Martin Odersky", "January 4, 2011"));
        books.add(new Book(5, "Head First Java", "Kathy Sierra", "February 9, 2005"));
        books.add(new Book(6, "JavaScript: The Good Parts", "Douglas Crockford", "May, 2008"));

        return books;
    }

    public String showWelcomeMessage() {
        return "----------   WELCOME TO BIBLIOTECA   ----------";
    }

    public String showMainMenuForCustomer() {

        return "----------   Main  Menu   ----------\n" +
                "\n[0] Exit BIBLIOTECA\n" +
                "[1] List Books of Library\n" +
                "[2] Check Out Book\n" +
                "[3] Return Book\n" +
                "\nPlease Enter Your Choice :";
    }

    public List<Book> getAvailableBooks(List<Book> books) {

        List<Book> availableBooks = new ArrayList<Book>();
        for(Book book: books) {

            if(!book.getIsBorrowed()) {

                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public String showBooksOfLibrary(List<Book> books) {

        String booksOfLibrary = "----------   BOOK LIST OF BIBLIOTECA   ----------\n";

        for(int i = 0; i < books.size(); i++) {
            booksOfLibrary += books.get(i).getBookInfo();
        }

        return booksOfLibrary;
    }


//    public void checkOutBook(Library library, User user) {
//
//        List<Book> books = this.getAvailableBooks(library);
//        this.showBooksOfLibrary(library);
//
//        System.out.println("Please Enter the Book Number You Want to Check Out:");
//        int checkOutNumber = Integer.parseInt(InputReaderHelper.getInput());
//
//        if(checkOutNumber < 0 && checkOutNumber > books.size()) {
//
//            System.out.println("\nSelect A Valid Option!\n");
//        } else {
//
//            books.get(checkOutNumber -1).setIsBorrowed(true);
//
//            List<Book> returnBooks = new ArrayList<Book>();
//            returnBooks.add(books.get(checkOutNumber));
//
//            user.setBorrowedBooks(returnBooks);
//            System.out.println("Thank you! Enjoy the book");
//        }
//    }

    public void returnBooks(User user) {

        this.showReturnBooks(user);
        System.out.println("Please Enter the Book Number You Want to Return:");

        int returnNumber = Integer.parseInt(InputReaderHelper.getInput());
        if(returnNumber < 0 && returnNumber > user.getBorrowedBooks().size()) {

            System.out.println("\nSelect A Valid Option!\n");
        } else {

            user.getBorrowedBooks().get(returnNumber - 1).setIsBorrowed(false);
            user.getBorrowedBooks().remove(returnNumber - 1);
            System.out.println("Thank you for returning the book");
        }
    }
    public void showReturnBooks(User user) {

        List<Book> books = user.getBorrowedBooks();
        System.out.println("----------   BORROWED BOOK LIST   ----------\n");

        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " BookName: " + books.get(i).getName() +
                    ", Author: " + books.get(i).getAuthor() + ", Publish Date: " +
                    books.get(i).getPublishedDate());
        }
    }

    public void checkOutBook(Book book, User user) {

        book.setIsBorrowed(true);

        List<Book> borrowedBooks = new ArrayList<Book>();
        borrowedBooks.add(book);

        user.setBorrowedBooks(borrowedBooks);

        System.out.println("Thank you! Enjoy the book");
    }


//    public List<Book> getAvailableBooks(Library library) {
//
//        List<Book> availableBooks = new ArrayList<Book>();
//        for(Book book: library.getBooks()) {
//
//            if(!book.getIsBorrowed()) {
//
//                availableBooks.add(book);
//            }
//        }
//
//        return availableBooks;
//    }
}
