package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MovieService;

import java.util.List;


public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        LibraryService libraryService = new LibraryService();
        BookService bookService = new BookService();
        MovieService movieService = new MovieService();

        Library library = new Library(bookService, movieService, libraryService);

        User currentUser;
        do {
            System.out.println(libraryService.showWelcomeMessage());
            currentUser = bibliotecaApp.userLogin(library.getUsers());
        } while(currentUser == null);

        libraryService.userOptionOfMainMenu(library, currentUser);
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
        System.out.println("\n----------   UserName Or Password Wrong   ----------\n");
        return null;
    }
}
