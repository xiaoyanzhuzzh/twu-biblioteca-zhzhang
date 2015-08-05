package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Library;

public class LibraryService {
//
//    private Library library;
//
//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
//    }

    public Library initLibrary() {
        BookService libraryService = new BookService();
        MovieService movieService = new MovieService();
        return new Library(libraryService, movieService);
    }

    public String showWelcomeMessage() {
        return "----------   WELCOME TO BIBLIOTECA   ----------";
    }

}
