package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;

public class BookService {

    private static Map<Book, Integer> bookInfo = newHashMap(
            ImmutableMap.of(
                    new Book("Refactoring", "Martin Flower", "2003"), 1,
                    new Book("Design Patterns", "GoF", "2000"), 2,
                    new Book("SICP", "Harold Abelson", "2004"), 3
            ));

    public Set<Book> allBooks() {
        return bookInfo.keySet();
    }
}
