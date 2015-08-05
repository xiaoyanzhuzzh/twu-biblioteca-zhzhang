package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Library;

public class LibraryService {

    private Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void initLibrary() {
        BookService libraryService = new BookService();
        MovieService movieService = new MovieService();
        library = new Library(libraryService, movieService);
    }
}
