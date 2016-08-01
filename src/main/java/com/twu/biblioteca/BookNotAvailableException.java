package com.twu.biblioteca;

public class BookNotAvailableException extends RuntimeException {

    public BookNotAvailableException() {
        super("book not available");
    }
}
