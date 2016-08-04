package com.twu.biblioteca.page;

import com.twu.biblioteca.MovieService;
import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CheckoutMoviePage implements Page {

    private final MovieService movieService;
    private final PrintStream printStream;
    private final Scanner scanner;

    public CheckoutMoviePage(MovieService movieService, PrintStream printStream, InputStream inputStream) {
        this.movieService = movieService;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public String execute(Session session) {
        printStream.println("Please select the movie you want to checkout out");
        String movieName = scanner.nextLine();
        movieService.checkoutMovie(movieName);
        return "Menu";
    }
}
