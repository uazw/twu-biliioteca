package com.twu.biblioteca.page;

import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ListOfBookPageTest {

    private BookService bookService;
    private ListOfBookPage listOfBookPage;

    @Before
    public void setUp() throws Exception {
        bookService = mock(BookService.class);
    }

    @Test
    public void shouldPresentAllAvailableBookWhenJumpToListPage() throws Exception {
        //given
        listOfBookPage = new ListOfBookPage(bookService, mock(PrintStream.class));

        //when
        listOfBookPage.execute();

        //then
        verify(bookService, times(1)).allExistedBooks();
    }

    @Test
    public void shouldReturnMenuPageWhenUserInputBack() throws Exception {
        //given
        listOfBookPage = new ListOfBookPage(bookService, mock(PrintStream.class));

        //when
        String nextPage = listOfBookPage.execute();

        //then
        assertThat(nextPage, is("Menu"));
    }
}