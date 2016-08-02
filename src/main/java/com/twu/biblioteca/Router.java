package com.twu.biblioteca;

import java.util.Map;

public class Router {

    private final Map<String, Page> routerMap;
    private final String defaultPath;

    public Router(Map<String, Page> routerMap, String defaultPath) {
        this.routerMap = routerMap;
        this.defaultPath = defaultPath;
    }

public void start() {
        routerMap.get(defaultPath).execute();
    }
}
