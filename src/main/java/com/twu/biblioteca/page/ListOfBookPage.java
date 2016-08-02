package com.twu.biblioteca.page;

import com.twu.biblioteca.BookService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class ListOfBookPage implements Page {

    private final BookService bookService;
    private final PrintStream printStream;
    private final Scanner scanner;

    public ListOfBookPage(BookService bookService, PrintStream printStream, InputStream inputStream) {
        this.bookService = bookService;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public String execute() {
        showBooks();
        return acceptUserInput();
    }

    private String acceptUserInput() {
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("back")) {
                return "menu";
            }
        }
        return "";
    }

    private void showBooks() {
        String books = bookService
                .allExistedBooks()
                .stream()
                .map(book -> book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getPublishYear())
                .collect(joining("\n"));

        printStream.println(books);
    }
}
