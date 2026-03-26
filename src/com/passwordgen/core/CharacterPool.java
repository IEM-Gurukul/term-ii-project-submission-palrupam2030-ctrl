package com.passwordgen.core;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class CharacterPool {
    private boolean useUppercase;
    private boolean useLowercase;
    private boolean useNumbers;
    private boolean useSymbols;

    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    private static final SecureRandom secureRandom = new SecureRandom();

    public CharacterPool(boolean useUppercase, boolean useLowercase, boolean useNumbers, boolean useSymbols) {
        this.useUppercase = useUppercase;
        this.useLowercase = useLowercase;
        this.useNumbers = useNumbers;
        this.useSymbols = useSymbols;
    }

    public boolean isUseUppercase() {
        return useUppercase;
    }

    public boolean isUseLowercase() {
        return useLowercase;
    }

    public boolean isUseNumbers() {
        return useNumbers;
    }

    public boolean isUseSymbols() {
        return useSymbols;
    }

    public String getPool() {
        StringBuilder pool = new StringBuilder();

        if (useUppercase) {
            pool.append(UPPERCASE);
        }
        if (useLowercase) {
            pool.append(LOWERCASE);
        }
        if (useNumbers) {
            pool.append(NUMBERS);
        }
        if (useSymbols) {
            pool.append(SYMBOLS);
        }

        return pool.toString();
    }

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