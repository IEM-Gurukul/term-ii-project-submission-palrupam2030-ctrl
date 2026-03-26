package com.passwordgen.core;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class CharacterPool {
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+<>?";
    
    private static final SecureRandom secureRandom = new SecureRandom();

    // Converts a string pool into a List of Characters (Demonstrates Collections)
    public static List<Character> getCharList(String pool) {
        List<Character> charList = new ArrayList<>();
        for (char c : pool.toCharArray()) {
            charList.add(c);
        }
        return charList;
    }

    public static SecureRandom getRandom() {
        return secureRandom;
    }
}