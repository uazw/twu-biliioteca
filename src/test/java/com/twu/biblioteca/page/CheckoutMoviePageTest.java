package com.twu.biblioteca.page;

import com.twu.biblioteca.MovieService;
import com.twu.biblioteca.framework.Session;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CheckoutMoviePageTest {

    @Test
    public void shouldCheckoutMovieSuccessfully() throws Exception {
        //given
        MovieService movieService = mock(MovieService.class);
        PrintStream printStream = mock(PrintStream.class);
        String movieName = "Zootopia";
        InputStream inputStream = new ByteArrayInputStream(movieName.getBytes());
        CheckoutMoviePage checkoutMoviePage = new CheckoutMoviePage(movieService, printStream, inputStream);

        //when
        checkoutMoviePage.execute(new Session());

        //then
        verify(movieService, times(1)).checkoutMovie(movieName);
    }

}