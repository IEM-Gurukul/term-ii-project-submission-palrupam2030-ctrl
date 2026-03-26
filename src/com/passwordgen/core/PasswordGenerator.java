package com.passwordgen.core;

import java.util.List;

public class PasswordGenerator implements Generator {

    protected CharacterPool characterPool;

    public PasswordGenerator(CharacterPool characterPool) {
        this.characterPool = characterPool;
    }

    @Override
    public String generatePassword(int length) {
        String pool = characterPool.getPool();

        if (pool.isEmpty()) {
            throw new IllegalArgumentException("Select at least one character type.");
        }

        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0.");
        }

        List<Character> charList = CharacterPool.getCharList(pool);
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = CharacterPool.getRandom().nextInt(charList.size());
            password.append(charList.get(index));
        }

        return password.toString();
    }
}