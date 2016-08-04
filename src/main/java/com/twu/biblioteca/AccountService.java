package com.twu.biblioteca;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class AccountService {

    private Map<String, String> accounts = newHashMap(ImmutableMap.of("123-4567", "password"));
    private Map<String, User> users = newHashMap(ImmutableMap.of(
            "123-4567", new User("uazw", "uazw@uazw.com", "1234567890")));

    public boolean isMatch(String account, String password) {
        String result = accounts.get(account);
        if (result != null && result.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String userDetail(String account) {
        User user = users.get(account);
        if (user != null) {
            return user.getName() + "\t" + user.getEmail() + "\t" + user.getPhone();
        }
        return "";
    }
}
