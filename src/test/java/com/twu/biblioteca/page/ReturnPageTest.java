package com.twu.biblioteca.page;

import com.twu.biblioteca.BookNotReturnableException;
import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class ReturnPageTest {

    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = mock(BookService.class);
    }

    @Test
    public void shouldReturnBookSuccessfullyWhenGivenAReturnableBookName() throws Exception {
        //given
        PrintStream printStream = mock(PrintStream.class);
        String bookName = "SICP";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bookName.getBytes());
        ReturnPage returnPage = new ReturnPage(bookService, printStream, inputStream);

        //when
        returnPage.execute();

        //then
        verify(bookService, times(1)).checkoutBookByName(bookName);
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldThrowExceptionWhenGivenANonReturnableBookName() throws Exception {
        //given
        PrintStream printStream = mock(PrintStream.class);
        String bookName = "SICP";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bookName.getBytes());
        ReturnPage returnPage = new ReturnPage(bookService, printStream, inputStream);
        doThrow(BookNotReturnableException.class).when(bookService).checkoutBookByName(eq(bookName));

        //when
        returnPage.execute();

        //then
        verify(bookService, times(1)).checkoutBookByName(bookName);
        verify(printStream).println("That is not a valid book to return.");
    }
}