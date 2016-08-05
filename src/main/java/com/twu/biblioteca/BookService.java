package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;
import com.twu.biblioteca.framework.Session;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toSet;

public class BookService {

    public static final String EMPTY_ACCOUNT = "";
    private Map<Book, String> bookInfo = newHashMap(
            ImmutableMap.of(
                    new Book("Refactoring", "Martin Flower", "2003"), EMPTY_ACCOUNT,
                    new Book("Design Patterns", "GoF", "2000"), EMPTY_ACCOUNT,
                    new Book("SICP", "Harold Abelson", "2004"), EMPTY_ACCOUNT
            ));

    public Set<Book> allExistedBooks() {
        return bookInfo.keySet()
                .stream()
                .filter(book -> isNotRent(book)).collect(toSet());
    }

    private boolean isNotRent(Book book) {
        return bookInfo.get(book).equals(EMPTY_ACCOUNT);
    }

    public void checkoutBookByName(String bookName, Session session) {

        Book book = findBookByName(bookName).orElse(null);
        if (book != null && isNotRent(book)) {
            bookInfo.put(book, session.getAccount());
        } else {
            throw new BookNotAvailableException();
        }
    }

    private Optional<Book> findBookByName(String bookName) {
        return bookInfo.keySet()
                .stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findFirst();
    }

    public void returnBookByName(String bookName) {
        Book book = findBookByName(bookName).orElse(null);
        if (book != null && !isNotRent(book)) {
            bookInfo.put(book, EMPTY_ACCOUNT);
        } else {
            throw new BookNotReturnableException();
        }
    }
}
