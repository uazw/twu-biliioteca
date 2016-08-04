package com.twu.biblioteca.framework;

import java.util.HashMap;
import java.util.Map;

public class Session {
    private Map<String, Object> session = new HashMap<>();

    public String getAccount() {
        return (String) session.get("ACCOUNT");
    }
}
