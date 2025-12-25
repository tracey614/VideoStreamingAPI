package com.streamingapi.demo.repo;

import com.streamingapi.demo.model.user;
 import java.util.Collection;
 import java.util.Map;
 import java.util.concurrent.ConcurrentHashMap;
 import java.util.stream.Collectors;

public class UserMemory {
    private final Map<String, user> usersByUsername = new ConcurrentHashMap<>();

    public boolean existsByUsername(String username) {
        return usersByUsername.containsKey(username);
    }

    public void save(user user) {
        usersByUsername.put(user.getUsername(), user);
    }

    public Collection<user> findAll() {
        return usersByUsername.values();
    }

    public Collection<user> findUsersWithCard(boolean hasCard) {
        return usersByUsername.values().stream()
                .filter(u -> (u.getCreditCardNumber() != null) == hasCard)
                .collect(Collectors.toList());
    }

    public boolean isCardRegistered(String cardNumber) {
        return usersByUsername.values().stream()
                .anyMatch(u -> cardNumber.equals(u.getCreditCardNumber()));
    }



}
