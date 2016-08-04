package com.twu.biblioteca.page;

import com.twu.biblioteca.framework.Session;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuPageTest {

    @Test
    public void shouldJumpToAnotherPageSuccessfullyWhenGivenAValidPage() throws Exception {
        //given
        String bookListPage = "List Books";
        InputStream inputStream = new ByteArrayInputStream(bookListPage.getBytes());
        MenuPage menuPage = new MenuPage(mock(PrintStream.class), inputStream);

        //when
        String nextPageName = menuPage.execute(new Session());

        //then
        assertThat(nextPageName, is(bookListPage));
    }

    @Test
    public void shouldShowErrorMessageWhenGivenAInvalidPage() throws Exception {
        //given
        String bookListPage = "Not Existed";
        InputStream inputStream = new ByteArrayInputStream(bookListPage.getBytes());
        PrintStream printStream = mock(PrintStream.class);
        MenuPage menuPage = new MenuPage(printStream, inputStream);

        //when
        menuPage.execute(new Session());

        //then
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldStopApplicationWhenGivenQuit() throws Exception {
        //given
        String bookListPage = "Quit";
        InputStream inputStream = new ByteArrayInputStream(bookListPage.getBytes());
        PrintStream printStream = mock(PrintStream.class);
        MenuPage menuPage = new MenuPage(printStream, inputStream);

        //when
        String nextPageName = menuPage.execute(new Session());

        //then
        assertThat(nextPageName, is(""));
    }
}