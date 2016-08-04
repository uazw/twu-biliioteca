package com.twu.biblioteca.framework;

import java.util.Map;

public class Router {

    private final Map<String, Page> routerMap;
    private final String defaultPath;
    private final Session session;

    public Router(Map<String, Page> routerMap, String defaultPath) {
        this.routerMap = routerMap;
        this.defaultPath = defaultPath;
        session = new Session();
    }

    public void start() {
        String nextPageName = defaultPath;
        do {
            nextPageName = routerMap.get(nextPageName).execute(session);
        } while (!nextPageName.equals(""));
    }
}
