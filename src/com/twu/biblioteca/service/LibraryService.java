package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private BookService bookService = new BookService();
    private MovieService movieService = new MovieService();

    public List<User> initUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        return users;
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

    public void userOptionOfMainMenu(Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(this.showMainMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n----------   Quit BIBLIOTECA System   ----------");
                    break;
                case 1:
                    this.userOptionOfBookMenu(library, user);
                    break;
                case 2:
                    this.userOptionOfMovieMenu(library, user);
                    break;
                case 3:
                    this.userOptionOfMovieMenu(library, user);
                    break;
                default:
                    System.out.println("\n----------   Select A Valid Option!   -----------\n");
            }
        }
    }

    public void userOptionOfBookMenu(Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(bookService.showBooksMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n----------   Exit Book Library   ----------\n");
                    this.showMainMenuForCustomer();
                    break;
                case 1:
                    System.out.println(bookService.showBooksOfLibrary(library.getBooks()));
                    break;
                case 2:
                    bookService.showCheckOutBooksMenu(library, user);
                    break;
                case 3:
                    bookService.showReturnBooksMenu(user);
                    break;
                default:
                    System.out.println("\n----------   Select A Valid Option!   -----------\n");
            }
        }

    }

    public void userOptionOfMovieMenu(Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(movieService.showMoviesMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n----------   Exit Movie Library   ----------\n");
                    this.showMainMenuForCustomer();
                    break;
                case 1:
                    System.out.println(movieService.showMoviesOfLibrary(library.getMovies()));
                    break;
                case 2:
                    movieService.showCheckOutMoviesMenu(library, user);
                    break;
                case 3:
                    movieService.showReturnMoviesMenu(user);
                    break;
                default:
                    System.out.println("\n----------   Select A Valid Option!   -----------\n");
            }
        }

    }
}
