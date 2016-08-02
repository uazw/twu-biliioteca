package com.twu.biblioteca;

import com.twu.biblioteca.page.Page;

import java.util.Map;

public class Router {

    private final Map<String, Page> routerMap;
    private final String defaultPath;

    public Router(Map<String, Page> routerMap, String defaultPath) {
        this.routerMap = routerMap;
        this.defaultPath = defaultPath;
    }

    public void start() {
        String nextPageName = defaultPath;
        do {
            nextPageName = routerMap.get(nextPageName).execute();
        } while (!nextPageName.equals(""));
    }
}
