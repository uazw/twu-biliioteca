package com.twu.biblioteca.page;

import com.twu.biblioteca.MovieService;
import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.PrintStream;

import static java.util.stream.Collectors.joining;

public class ListOfMoviePage implements Page {

    private MovieService movieService;
    private PrintStream printStream;

    public ListOfMoviePage(MovieService movieService, PrintStream printStream) {
        this.movieService = movieService;
        this.printStream = printStream;
    }

    @Override
    public String execute(Session session) {
        String movies = movieService
                .allAvailableMovies()
                .stream()
                .map(movie -> movie.getName() + "\t" + movie.getYear()
                        + "\t" + movie.getDirector() + "\t" + movie.getRate())
                .collect(joining("\n"));

        printStream.println(movies);
        return "Menu";
    }
}
