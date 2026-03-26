package com.passwordgen.core;

import com.passwordgen.policy.PasswordPolicy;

public class PasswordGenerator {
    private PasswordPolicy policy;

    public PasswordGenerator(PasswordPolicy policy) {
        this.policy = policy;
    }

    public void setPolicy(PasswordPolicy policy) {
        this.policy = policy;
    }

    public String generate(int length, boolean upper, boolean lower, boolean numbers, boolean symbols) {
        // Delegates to the currently selected policy
        return policy.generatePassword(length, upper, lower, numbers, symbols);
    }
}