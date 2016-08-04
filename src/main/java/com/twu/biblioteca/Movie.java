package com.twu.biblioteca;

public class Movie {

    private final String name;
    private final String year;
    private final String director;
    private final Rate rate;

    public Movie(String name, String year, String director, Rate rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Rate getRate() {
        return rate;
    }
}
