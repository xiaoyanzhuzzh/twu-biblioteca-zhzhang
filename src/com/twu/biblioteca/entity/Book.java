package com.twu.biblioteca.entity;

public class Book {

    private String name;
    private String author;
    private String publishedDate;

    public Book() {

    }

    public Book(String name, String author, String publishedDate) {
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                '}';
    }
}
