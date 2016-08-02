package com.twu.biblioteca;


import com.twu.biblioteca.page.Page;

public class FirstPage implements Page {

    @Override
    public String execute() {
        return "second";
    }
}
