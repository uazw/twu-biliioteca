package com.twu.biblioteca.page;

import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
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
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Bookname".getBytes());
        listOfBookPage = new ListOfBookPage(bookService, mock(PrintStream.class), inputStream);

        //when
        listOfBookPage.execute();

        //then
        verify(bookService, times(1)).allExistedBooks();
    }

    @Test
    public void shouldReturnMenuPageWhenUserInputBack() throws Exception {
        //given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("back".getBytes());
        listOfBookPage = new ListOfBookPage(bookService, mock(PrintStream.class), inputStream);

        //when
        String nextPage = listOfBookPage.execute();

        //then
        assertThat(nextPage, is("menu"));
    }
}