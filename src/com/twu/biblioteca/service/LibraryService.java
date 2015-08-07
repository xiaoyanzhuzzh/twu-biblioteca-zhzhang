package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.helper.InputReaderHelper;

import java.util.List;

public class LibraryService {

    private BookService bookService = new BookService();
    private MovieService movieService = new MovieService();
    private UserService userService = new UserService();

    public String showWelcomeMessage() {
        return "----------   WELCOME TO BIBLIOTECA   ----------";
    }

    public String showMainMenuForCustomer() {

         return "----------   Main  Menu of BIBLIOTECA  ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] List Books of Library\n" +
                "[2] List Movies of Library\n" +
                "[3] Show Your Own Information\n" +
                "\nPlease Enter Your Choice :";
    }

    public String showMainMenuForLibrarian() {
        return "----------   Main  Menu of BIBLIOTECA  ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] Enter Book Library\n" +
                "[2] Enter Movie Library\n" +
                "[3] Show Who Borrow Book & Movie\n" +
                "\nPlease Enter Your Choice :";
    }

    public User userLogin(Library library) {

        System.out.println("Please enter your userName:");
        String userName = InputReaderHelper.getInput();
        System.out.println("Please enter your password:");
        String password = InputReaderHelper.getInput();

        User user = new User(userName, password);
        user = userService.userLogin(user, library.getUsers());
        if(user == null) {

            System.out.println("\n----------   UserName Or Password Wrong   ----------\n");
        } else if(user.getType().equals("customer")) {

            System.out.println("----------   Dear " + userName + ", Login Success!   ----------\n");
            customerOptionOfMainMenu(library, user);
        } else if(user.getType().equals("librarian")) {

            System.out.println("Dear " + userName + ", Login Success!\n");
            this.librarianOptionOfMainMenu(library, user);
        }
        return user;
    }

    public String showCustomersWithBorrowedBooks(List<User> users) {

        List<User> customersWithBorrowedBooks = userService.getCustomersWithBorrowedBooks(users);

        String result = "\n----------   Who Borrow Books?   ----------\n";
        for(User customer: customersWithBorrowedBooks) {

            result += "Customer: " + customer.getName() + "\n";
            for(Book book: customer.getBorrowedBooks()) {

                result += book.getBookInfo();
            }
        }
        return result;
    }

    private void librarianOptionOfMainMenu(Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(this.showMainMenuForLibrarian());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n----------   Quit BIBLIOTECA System   ----------");
                    break;
                case 1:
                    this.librarianOptionOfBookMenu(library, user);
                    break;
                case 2:
                    this.librarianOptionOfMovieMenu(library, user);
                    break;
                case 3:
//                    System.out.println(userService.showCustomerInformation(user));
                    break;
                default:
                    System.out.println("\n----------   Select A Valid Option!   -----------\n");
            }
        }
    }

    private void librarianOptionOfMovieMenu(Library library, User user) {
        this.customerOptionOfMovieMenu(library, user);
    }

    private void librarianOptionOfBookMenu(Library library, User user) {
        this.customerOptionOfBookMenu(library, user);
    }

    private void customerOptionOfMainMenu(Library library, User user) {

        int input = -1;
        while(input != 0) {
            System.out.println(this.showMainMenuForCustomer());
            input = Integer.parseInt(InputReaderHelper.getInput());
            switch(input) {
                case 0:
                    System.out.println("\n----------   Quit BIBLIOTECA System   ----------");
                    break;
                case 1:
                    this.customerOptionOfBookMenu(library, user);
                    break;
                case 2:
                    this.customerOptionOfMovieMenu(library, user);
                    break;
                case 3:
                    System.out.println(userService.showCustomerInformation(user));
                    break;
                default:
                    System.out.println("\n----------   Select A Valid Option!   -----------\n");
            }
        }
    }

    private void customerOptionOfBookMenu(Library library, User user) {

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

    private void customerOptionOfMovieMenu(Library library, User user) {

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
