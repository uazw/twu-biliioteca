package com.twu.biblioteca;

public class BookNotReturnableException extends RuntimeException {
    public BookNotReturnableException() {
        super("book can't return at right now");
    }
}
