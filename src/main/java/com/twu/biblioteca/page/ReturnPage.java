package com.twu.biblioteca.page;

import com.twu.biblioteca.BookNotReturnableException;
import com.twu.biblioteca.BookService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReturnPage implements Page {

    private final BookService bookService;
    private final PrintStream printStream;
    private final Scanner scanner;

    public ReturnPage(BookService bookService, PrintStream printStream, InputStream inputStream) {
        this.bookService = bookService;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public String execute() {
        printStream.println("Please input book name you want to return: ");
        try {
            bookService.returnBookByName(scanner.nextLine());
            printStream.println("Thank you for returning the book.");
        } catch (BookNotReturnableException ex) {
            printStream.println("That is not a valid book to return.");
        }
        return "Menu";
    }
}
