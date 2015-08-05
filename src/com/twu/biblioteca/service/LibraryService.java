package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;

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

         return "----------   Main  Menu of BIBLIOTECA  ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] List Books of Library\n" +
                "[2] List Movies of Library\n" +
                "\nPlease Enter Your Choice :";
    }

    public void userOptionOfMainMenu(BookService bookService, MovieService movieService, Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(this.showMainMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n----------   Quit BIBLIOTECA System   ----------");
                    break;
                case 1:
                    bookService.userOptionOfBookMenu(library, user);
                    break;
                case 2:
//                    System.out.println(movieService.showMoviesOfLibrary(library.getMovies()));
                    break;
                case 3:
                    bookService.showReturnBooksMenu(user);
                    break;
                default:
                    System.out.println("\n----------   Select A Valid Option!   -----------\n");
            }
        }

    }
}
