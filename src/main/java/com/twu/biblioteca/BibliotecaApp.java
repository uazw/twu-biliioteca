package com.twu.biblioteca;

import com.twu.biblioteca.page.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class BibliotecaApp {

    public static void main(String[] args) {
        RouterBuilder builder = new RouterBuilder();
        BookService bookService = new BookService();

        Router router = builder
                .path("welcome", new WelcomePage(out))
                .path("List Books", new ListOfBookPage(bookService, out, in))
                .path("Checkout Book", new CheckoutPage(bookService, out, in))
                .path("Return Book", new ReturnPage(bookService, out, in))
                .path("Menu", new MenuPage(out, in))
                .defaultPath("welcome")
                .build();

        router.start();
    }
}
