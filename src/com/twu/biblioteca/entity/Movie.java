package com.twu.biblioteca.entity;

public class Movie {

    private int id;
    private String name;
    private String year;
    private String director;
    private int rating;
    private boolean isBorrowed;

    public Movie() {

    }

    public Movie(int id, String name, String year, String director, int rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isBorrowed = false;
    }

    public Movie(int id, String name, String year, String director, int rating, boolean isBorrowed) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isBorrowed = isBorrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public String getMovieInfo() {

        return "[" + this.getId() + "] " + "MovieName: " + this.getName() + ", Year: " + this.getYear() + ", Director: " + this.getDirector() +
                ", MovieRating: " + this.getRating() + "\n";
    }
}
