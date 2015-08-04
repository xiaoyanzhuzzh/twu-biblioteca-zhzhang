package com.twu.biblioteca.entity;

public class Book {

    private int id;
    private String name;
    private String author;
    private String publishedDate;
    private boolean isBorrowed;

    public Book() {

    }

    public Book(int id, String name, String author, String publishedDate) {
        this.id += id;
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
        this.isBorrowed = false;
    }

    public Book(int id, String name, String author, String publishedDate, boolean isBorrowed) {
        this.id += id;
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
        this.isBorrowed = isBorrowed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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


    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public String getBookInfo() {

        return "[" + this.getId()  + "] "+ "BookName: " + this.getName() + ", Author: " + this.getAuthor() + ", Publish Date: " + this.getPublishedDate() + "\n";
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
