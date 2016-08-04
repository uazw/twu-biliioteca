package com.twu.biblioteca.page;

import com.twu.biblioteca.BookNotAvailableException;
import com.twu.biblioteca.BookService;
import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CheckoutPage implements Page {

    private final BookService bookService;
    private final PrintStream printStream;
    private final Scanner scanner;

    public CheckoutPage(BookService bookService, PrintStream printStream, InputStream inputStream) {
        this.bookService = bookService;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public String execute(Session session) {
        printStream.println("Please input the book's name you want to checkout: ");
        try {
            bookService.checkoutBookByName(scanner.nextLine());
            printStream.println("Thank you! Enjoy the book");
        } catch (BookNotAvailableException ex) {
            printStream.println("That book is not available.");
        }
        return "Menu";
    }
}
