package com.example.password;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {
    private static final String NUMBERS = "0123456789";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";
    private final int length;
    private final boolean includeNumbers;
    private final boolean includeLowercase;
    private final boolean includeUppercase;
    private final boolean includeSpecial;

    public PasswordGenerator(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        this.length = length;
        this.includeNumbers = includeNumbers;
        this.includeLowercase = includeLowercase;
        this.includeUppercase = includeUppercase;
        this.includeSpecial = includeSpecial;
    }

    public String generate() {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than zero.");
        }

        StringBuilder characterSet = new StringBuilder();
        if (includeNumbers) {
            characterSet.append(NUMBERS);
        }
        if (includeLowercase) {
            characterSet.append(LOWERCASE_LETTERS);
        }
        if (includeUppercase) {
            characterSet.append(UPPERCASE_LETTERS);
        }
        if (includeSpecial) {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be included.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }
}
