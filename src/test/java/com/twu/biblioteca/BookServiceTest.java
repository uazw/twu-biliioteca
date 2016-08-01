package com.twu.biblioteca;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookServiceTest {

    private BookService bookService = new BookService();

    @Test
    public void shouldReturnAllBooks() throws Exception {
        //given

        //when
        Set<Book> books = bookService.allBooks();

        //then
        assertThat(books.size(), is(3));
    }

    @Test
    public void shouldR() throws Exception {
        //given

        //when

        //then
    }
}