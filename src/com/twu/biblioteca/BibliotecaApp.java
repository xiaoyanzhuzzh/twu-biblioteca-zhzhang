package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;
import com.twu.biblioteca.service.LibraryService;

import java.util.List;


public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        LibraryService libraryService = new LibraryService();
        System.out.println(libraryService.showWelcomeMessage());

        Library library = new Library(libraryService);
        User currentUser = bibliotecaApp.userLogin(library.getUsers());
        if(currentUser != null) {

            bibliotecaApp.userOption(libraryService, library, currentUser);
        }
    }

    public User userLogin(List<User> users) {

        System.out.println("Please enter your userName:");
        String userName = InputReaderHelper.getInput();
        System.out.println("Please enter your password:");
        String password = InputReaderHelper.getInput();

        for(User user: users) {
            if(user.getName().equals(userName) && user.getPassword().equals(password)) {
                System.out.println("Dear " + userName + ", Login Success!\n");
                return new User(userName, password);
            }
        }
        System.out.println("----UserName Or Password Wrong----");
        return null;
    }

    public void userOption(LibraryService libraryService, Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(libraryService.showMainMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n---------- EXIT BIBLIOTECA ----------");
                    break;
                case 1:
                    libraryService.showBooksOfLibrary(library);
                    break;
                case 2:
                    libraryService.checkOutBook(library, user);
                    break;
                case 3:
                    libraryService.returnBooks(user);
                    break;
                default:
                    System.out.println("\nSelect A Valid Option!\n");
            }
        }

    }
}
