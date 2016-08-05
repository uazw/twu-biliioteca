package com.twu.biblioteca;

import com.twu.biblioteca.framework.Session;
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
        Session session = new Session();
        session.setAccount("123-4567");

        //when
        bookService.checkoutBookByName("SICP", session);

        //then
        assertThat(bookService.allExistedBooks().size(), is(2));
    }

    @Test(expected = BookNotAvailableException.class)
    public void shouldThrowExceptionWhenGivenAnNotExistedBook() throws Exception {
        //given
        Session session = new Session();
        session.setAccount("123-4567");

        //when
        bookService.checkoutBookByName("Data Structure", session);

        //then

    }

    @Test(expected = BookNotAvailableException.class)
    public void shouldFailToCheckoutWhenGivenAnAlreadyCheckoutBook() throws Exception {
        //given
        Session session = new Session();
        session.setAccount("123-4567");


        //when
        bookService.checkoutBookByName("SICP", session);
        bookService.checkoutBookByName("SICP", session);

        //then
    }

    @Test
    public void shouldUserCanCheckoutBookSuccessfullyWhenGivenAnAlreadyCheckoutBook() throws Exception {
        //given
        Session session = new Session();
        session.setAccount("123-4567");

        bookService.checkoutBookByName("SICP", session);

        //when
        bookService.returnBookByName("SICP");

        //then
        assertThat(bookService.allExistedBooks().size(), is(3));
    }

    @Test(expected = BookNotReturnableException.class)
    public void shouldThrowExceptionWhenGivenBookNotReturnable() throws Exception {
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