package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieServiceTest {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieService = new MovieService();

    }

    @Test
    public void shouldReturnAllAvailableMovies() throws Exception {
        //given

        //when
        Set<Movie> movies = movieService.allAvailableMovies();

        //then
        assertThat(movies.size(), is(3));
    }

    @Test
    public void shouldCheckoutMovieSuccessfullyWhenGivenAAvailableMovieName() throws Exception {
        //given

        //when
        movieService.checkoutMovie("Zootopia");

        //then
        assertThat(movieService.allAvailableMovies().size(), is(2));
    }
}