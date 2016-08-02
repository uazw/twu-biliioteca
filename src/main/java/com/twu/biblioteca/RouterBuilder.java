package com.twu.biblioteca;

import com.twu.biblioteca.page.Page;

import java.util.HashMap;
import java.util.Map;

public class RouterBuilder {

    private final Map<String, Page> routerMap;
    private String defaultPath;

    public RouterBuilder() {
        routerMap = new HashMap<>();
    }

    public RouterBuilder path(String pageName, Page page) {
        routerMap.put(pageName, page);
        return this;
    }

    public RouterBuilder defaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
        return this;
    }

    public Router build() {
        return new Router(routerMap, defaultPath);
    }
}
