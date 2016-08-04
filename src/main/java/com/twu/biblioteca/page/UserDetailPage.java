package com.twu.biblioteca.page;

import com.twu.biblioteca.AccountService;
import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

import java.io.PrintStream;

public class UserDetailPage implements Page {

    private final AccountService accountService;
    private final PrintStream printStream;

    public UserDetailPage(AccountService accountService, PrintStream printStream) {
        this.accountService = accountService;
        this.printStream = printStream;
    }

    @Override
    public String execute(Session session) {
        String userDetail = accountService.userDetail(session.getAccount());
        printStream.println(userDetail);
        return "Menu";
    }
}
