package com.passwordgen.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecurePasswordGenerator extends PasswordGenerator {

    public SecurePasswordGenerator(CharacterPool characterPool) {
        super(characterPool);
    }

    @Override
    public String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Secure password length must be at least 4.");
        }

        String pool = characterPool.getPool();

        if (pool.isEmpty()) {
            throw new IllegalArgumentException("Select at least one character type.");
        }

        List<Character> passwordChars = new ArrayList<>();

        if (characterPool.isUseUppercase()) {
            passwordChars.add(getRandomChar(CharacterPool.UPPERCASE));
        }
        if (characterPool.isUseLowercase()) {
            passwordChars.add(getRandomChar(CharacterPool.LOWERCASE));
        }
        if (characterPool.isUseNumbers()) {
            passwordChars.add(getRandomChar(CharacterPool.NUMBERS));
        }
        if (characterPool.isUseSymbols()) {
            passwordChars.add(getRandomChar(CharacterPool.SYMBOLS));
        }

        List<Character> allChars = CharacterPool.getCharList(pool);

        while (passwordChars.size() < length) {
            int index = CharacterPool.getRandom().nextInt(allChars.size());
            passwordChars.add(allChars.get(index));
        }

        Collections.shuffle(passwordChars);

        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }

    private char getRandomChar(String source) {
        int index = CharacterPool.getRandom().nextInt(source.length());
        return source.charAt(index);
    }
}