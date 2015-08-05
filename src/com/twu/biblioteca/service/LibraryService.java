package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Library;

public class LibraryService {

    public Library initLibrary() {
        BookService libraryService = new BookService();
        MovieService movieService = new MovieService();
        return new Library(libraryService, movieService);
    }

    public String showWelcomeMessage() {
        return "----------   WELCOME TO BIBLIOTECA   ----------";
    }


    public String showMainMenuForCustomer() {

         return "----------   Main  Menu   ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] List Books of Library\n" +
                "[2] List Movies of Library\n" +
                "\nPlease Enter Your Choice :";
    }
}
