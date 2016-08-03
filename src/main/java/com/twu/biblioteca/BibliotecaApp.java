package com.twu.biblioteca;

import com.twu.biblioteca.page.CheckoutPage;
import com.twu.biblioteca.page.ListOfBookPage;
import com.twu.biblioteca.page.WelcomePage;

import static java.lang.System.in;
import static java.lang.System.out;

public class BibliotecaApp {

    public static void main(String[] args) {
        RouterBuilder builder = new RouterBuilder();
        BookService bookService = new BookService();

        Router router = builder
                .path("welcome", new WelcomePage(out))
                .path("books", new ListOfBookPage(bookService, out, in))
                .path("checkout", new CheckoutPage(bookService, out, in))
                .defaultPath("welcome")
                .build();

        router.start();
    }
}
