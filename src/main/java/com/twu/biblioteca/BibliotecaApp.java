package com.twu.biblioteca;

import com.twu.biblioteca.page.WelcomePage;

import static java.lang.System.out;

public class BibliotecaApp {

    public static void main(String[] args) {
        RouterBuilder builder = new RouterBuilder();
        Router router = builder
                .path("welcome", new WelcomePage(out))
                .defaultPath("welcome")
                .build();

        router.start();
    }
}
