package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookServiceTest {

    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookService();
    }


    @Test
    public void shouldReturnAllBooks() throws Exception {
        //given

        //when
        Set<Book> books = bookService.allExistedBooks();

        //then
        assertThat(books.size(), is(3));
    }

    @Test
    public void shouldCheckoutSuccessfullyWhenGivenAnExistedBook() throws Exception {
        //given

        //when
        bookService.checkoutBookByName("SICP");

        //then
        assertThat(bookService.allExistedBooks().size(), is(2));
    }

    @Test(expected = BookNotReturnableException.class)
    public void shouldThrowExceptionWhenGivenAnNotExistedBook() throws Exception {
        //given

        //when
        bookService.checkoutBookByName("Data Structure");

        //then

    }

    @Test(expected = BookNotReturnableException.class)
    public void shouldFailToCheckoutWhenGivenAnAlreadyCheckoutBook() throws Exception {
        //given
        bookService.checkoutBookByName("SICP");

        //when
        bookService.checkoutBookByName("SICP");

        //then
    }

    @Test
    public void shouldUserCanCheckoutBookSuccessfullyWhenGivenAnAlreadyCheckoutBook() throws Exception {
        //given
        bookService.checkoutBookByName("SICP");

        //when
        bookService.returnBookByName("SICP");

        //then
        assertThat(bookService.allExistedBooks().size(), is(3));
    }

    @Test(expected = BookNotReturnableException.class)
    public void shouldThrowExceptionWhenGivenHavenotCheckoutedBook() throws Exception {
        //given

        //when
        bookService.returnBookByName("SICP");

        //then
    }

    @Test(expected = BookNotReturnableException.class)
    public void shouldThrowExceptionWhenGivenNotInLibraryBook() throws Exception {
        //given

        //when
        bookService.returnBookByName("Data Structure");

        //then
    }
}