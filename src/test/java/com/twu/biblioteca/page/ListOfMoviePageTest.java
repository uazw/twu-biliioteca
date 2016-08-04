package com.twu.biblioteca.page;

import com.twu.biblioteca.MovieService;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class ListOfMoviePageTest {

    @Test
    public void shouldReturnListOfMovies() throws Exception {
        //given
        MovieService movieService = mock(MovieService.class);
        ListOfMoviePage listOfMoviePage = new ListOfMoviePage(movieService, mock(PrintStream.class));

        //when
        listOfMoviePage.execute();

        //then
        verify(movieService, times(1)).allAvailableMovies();
    }

}