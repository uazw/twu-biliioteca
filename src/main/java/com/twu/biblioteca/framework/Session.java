package com.twu.biblioteca.framework;

import java.util.HashMap;
import java.util.Map;

public class Session {
    public static final String ACCOUNT_KEY = "ACCOUNT";
    private Map<String, Object> session = new HashMap<>();

    public String getAccount() {
        return (String) session.get(ACCOUNT_KEY);
    }

    public void setAccount(String account) {
        session.put(ACCOUNT_KEY, account);
    }
}
