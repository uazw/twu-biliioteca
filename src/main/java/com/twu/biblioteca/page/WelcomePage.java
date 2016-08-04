package com.twu.biblioteca.page;

import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.PrintStream;

public class WelcomePage implements Page {

    private PrintStream printStream;

    public WelcomePage(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public String execute(Session session) {
        printStream.println("welcome");
        return "Login";
    }
}
