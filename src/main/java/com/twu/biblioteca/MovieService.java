package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static com.twu.biblioteca.Rate.EIGHT;
import static com.twu.biblioteca.Rate.NINE;
import static java.util.stream.Collectors.toSet;

public class MovieService {

    private Map<Movie, Boolean> movies = newHashMap(
            ImmutableMap.of(
                    new Movie("Zootopia", "Byron Howard", "2016", NINE), false,
                    new Movie("Despicable Me", "Pierre Coffin", "2010", EIGHT), false,
                    new Movie("Big Hero", "Don Hall", "2015", EIGHT), false
            ));


    public Set<Movie> allAvailableMovies() {
        return movies.keySet()
                .stream()
                .filter(movie -> !movies.get(movie)).collect(toSet());
    }

    public void checkoutMovie(String movieName) {
        movies.keySet()
                .stream()
                .filter(movie -> movie.getName().equals(movieName))
                .findFirst()
                .ifPresent(movie -> movies.put(movie, true));
    }
}
