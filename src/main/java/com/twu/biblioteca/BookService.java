package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toSet;

public class BookService {

    private Map<Book, Boolean> bookInfo = newHashMap(
            ImmutableMap.of(
                    new Book("Refactoring", "Martin Flower", "2003"), false,
                    new Book("Design Patterns", "GoF", "2000"), false,
                    new Book("SICP", "Harold Abelson", "2004"), false
            ));

    public Set<Book> allExistedBooks() {
        return bookInfo.keySet()
                .stream()
                .filter(book -> !bookInfo.get(book).booleanValue()).collect(toSet());
    }

    public void checkoutBookByName(String bookName) {

        Book book = findBookByName(bookName).orElse(null);
        if (book != null && !bookInfo.get(book)) {
            bookInfo.put(book, true);
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
        if (book != null && bookInfo.get(book)) {
            bookInfo.put(book, false);
        } else {
            throw new BookNotReturnableException();
        }
    }
}
