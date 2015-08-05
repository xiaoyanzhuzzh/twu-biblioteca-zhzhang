package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;

public class BibliotecaApp {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();

        BookService bookService = new BookService();
        MovieService movieService = new MovieService();
        UserService userService = new UserService();

        Library library = new Library(bookService, movieService, userService);

        User currentUser;
        do {
            System.out.println(libraryService.showWelcomeMessage());
            currentUser = libraryService.userLogin(library);
        } while(currentUser == null);
    }
}
