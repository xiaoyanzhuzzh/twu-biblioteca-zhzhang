package com.twu.biblioteca.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void initBook() {
        book = new Book();
    }

    @Test
    public void canSetBookName() {
        String name = "Refactoring: Improving the Design of Existing Code";
        book.setName(name);
        assertEquals(name, book.getName());
    }

    @Test
    public void canSetBookAuthor() {
        String author = "Martin Fowler";
        book.setAuthor(author);
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void canSetPublishedDate() {
        String date = "July 8, 1999";
        book.setPublishedDate(date);
        assertEquals(date, book.getPublishedDate());
    }

    @Test
    public void canSetIsBorrowed() {
        String date = "July 8, 1999";
        book.setIsBorrowed(false);
        assertEquals(false, book.getIsBorrowed());
    }

    @Test
    public void constructorTest() {
        book = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "July 8, 1999");
        assertEquals("Refactoring: Improving the Design of Existing Code", book.getName());
        assertEquals("Martin Fowler", book.getAuthor());
        assertEquals("July 8, 1999", book.getPublishedDate());
    }

}
