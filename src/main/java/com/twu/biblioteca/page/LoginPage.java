package com.twu.biblioteca.page;

import com.twu.biblioteca.AccountService;
import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LoginPage implements Page {

    private final AccountService accountService;
    private final PrintStream printStream;
    private final Scanner scanner;

    public LoginPage(AccountService accountService, PrintStream printStream, InputStream inputStream) {
        this.accountService = accountService;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public String execute(Session session) {
        printStream.println("Please input your account");
        String account = scanner.nextLine();
        printStream.println("Please input your password");
        String password = scanner.nextLine();
        boolean match = accountService.isMatch(account, password);
        if (match) {
            session.setAccount(account);
            return "Menu";
        } else {
           return "Login";
        }
    }
}
