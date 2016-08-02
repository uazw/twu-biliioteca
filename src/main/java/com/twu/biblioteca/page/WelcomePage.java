package com.twu.biblioteca.page;

import java.io.PrintStream;

public class WelcomePage implements Page {

    private PrintStream printStream;

    public WelcomePage(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public String execute() {
        printStream.println("welcome");
        return "";
    }
}
