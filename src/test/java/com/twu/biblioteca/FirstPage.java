package com.twu.biblioteca;


import com.twu.biblioteca.framework.Page;
import com.twu.biblioteca.framework.Session;

public class FirstPage implements Page {

    @Override
    public String execute(Session session) {
        return "second";
    }
}
