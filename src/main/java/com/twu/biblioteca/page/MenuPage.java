package com.twu.biblioteca.page;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.google.common.collect.Lists.newArrayList;

public class MenuPage implements Page {

    private final PrintStream printStream;
    private final Scanner scanner;

    public MenuPage(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public String execute() {
        printStream.println("plase input next page you wanna go(List Books, Checkout Book, Return Book, Quit): ");
        String nextPageName = scanner.nextLine();
        if (newArrayList("List Books", "Checkout Book", "Return Book").contains(nextPageName)) {
            return nextPageName;
        } else if (nextPageName.equals("Quit")) {
            return "";
        } else {
            printStream.println("Select a valid option!");
            return "Menu";
        }
    }
}
