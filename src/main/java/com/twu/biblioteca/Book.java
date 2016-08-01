package com.twu.biblioteca;

public class Book {

    private String title;
    private String Author;
    private String publishYear;

    public Book() {
    }

    public Book(String title, String author, String publishYear) {
        this.title = title;
        Author = author;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
