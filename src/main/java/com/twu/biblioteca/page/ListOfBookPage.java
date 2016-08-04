package com.twu.biblioteca.page;

import com.twu.biblioteca.BookService;
import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.PrintStream;

import static java.util.stream.Collectors.joining;

public class ListOfBookPage implements Page {

    private final BookService bookService;
    private final PrintStream printStream;

    public ListOfBookPage(BookService bookService, PrintStream printStream) {
        this.bookService = bookService;
        this.printStream = printStream;
    }

    @Override
    public String execute(Session session) {
        String books = bookService
                .allExistedBooks()
                .stream()
                .map(book -> book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getPublishYear())
                .collect(joining("\n"));

        printStream.println(books);

        return "Menu";
    }

}
