package com.company.JavaCore.Lesson4;

import java.util.*;

public class PhonesDictionary {
    private final Map<String, Set<String>> dictionary;

    public PhonesDictionary(Map<String, Set<String>> dictionary) {
        this.dictionary = dictionary;
    }

    public PhonesDictionary() {
        dictionary =  new HashMap<>();
    }

    public void add(String name, String phone) {
        if (name == null || phone == null) return;
        dictionary.putIfAbsent(name, new HashSet<>());
        dictionary.get(name).add(phone);
    }

    public Set<String> getPhones(String name) {
        if  (name == null) return null;
        return dictionary.get(name);
    }
}
