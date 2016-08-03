package com.twu.biblioteca.page;

import com.twu.biblioteca.BookNotAvailableException;
import com.twu.biblioteca.BookService;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CheckoutPageTest {

    private CheckoutPage checkoutPage;
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = mock(BookService.class);
    }

    @Test
    public void shouldCheckoutBookSuccessfullyWhenGivenANAvailableBookName() throws Exception {
        //given
        PrintStream out = mock(PrintStream.class);
        InputStream in = new ByteArrayInputStream("SICP".getBytes());
        checkoutPage = new CheckoutPage(bookService, out, in);
        String bookName = "SICP";

        //when
        checkoutPage.execute();

        //then
        verify(bookService, times(1)).checkoutBookByName(bookName);
        verify(out).println("Thank you! Enjoy the book");
    }
    @Test
    public void shouldShowErrorMessageWhenGivenAnUnavailableBookName() throws Exception {
        //given
        PrintStream out = mock(PrintStream.class);
        String bookName = "SICP";
        InputStream in = new ByteArrayInputStream(bookName.getBytes());
        checkoutPage = new CheckoutPage(bookService, out, in);
        doThrow(BookNotAvailableException.class).when(bookService).checkoutBookByName(eq(bookName));

        //when
        checkoutPage.execute();

        //then
        verify(bookService, times(1)).checkoutBookByName(bookName);
        verify(out).println("That book is not available.");
    }
}