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

}
