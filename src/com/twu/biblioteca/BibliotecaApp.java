package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;
import com.twu.biblioteca.helper.Libraryhelper;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp =  new BibliotecaApp();
        bibliotecaApp.showWelcomeMessage();

        Library library = new Libraryhelper().initLibrary();
        if(bibliotecaApp.userLogin(library.getUsers())) {

            bibliotecaApp.showCustomerOption(library.getBooks());
        }
    }

    public void showWelcomeMessage() {

        String welcomeMessage = "----- WELCOME TO BIBLIOTECA -----\n";
        System.out.println(welcomeMessage);
    }

    public Boolean userLogin(List<User> users) {
        System.out.println("Please enter your userName:");
        String userName = InputReaderHelper.getInput();
        System.out.println("Please enter your password:");
        String password = InputReaderHelper.getInput();

        for(User user: users) {
            if(user.getName().equals(userName) && user.getPassword().equals(password)) {
                System.out.println("Dear " + userName + ", Login Success!\n");
                return true;
            }
        }
        System.out.println("----UserName Or Password Wrong----");
        return false;

    }

    public String showMainMenuForCustomer() {

        return "---------- Main  Menu ----------\n" +
                "\n[0] Exit BIBLIOTECA\n" +
                "[1] List Books of Library\n" +
                "\nPlease Enter Your Choice :";
    }

    public void showCustomerOption(List<Book> books) {

        int input = -1;
        while(input != 0) {
            System.out.println(this.showMainMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 1:
                    this.showBooksOfLibrary(books);
                    break;
                case 0:
                    System.out.println("\n---------- EXIT BIBLIOTECA ----------");
                    break;
                default:
                    System.out.println("\nThe Input Is Illegal!\n");
            }
        }

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

}
