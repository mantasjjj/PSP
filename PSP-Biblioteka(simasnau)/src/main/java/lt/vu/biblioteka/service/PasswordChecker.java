package main.java.lt.vu.biblioteka.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordChecker {
    private static final int MINIMUM_PASSWORD_LENGTH = 6;
    private final List<Character> SPECIAL_CHARACTERS_LIST = new ArrayList<>(Arrays.asList('#', '$'));

    public PasswordChecker() {
    }

    public boolean isPasswordValid(String password) {
        return isPasswordLengthValid(password) && doesPasswordHaveUppercase(password) && doesPasswordContainSpecialCharacters(password);
    }

    private boolean isPasswordLengthValid(String password) {
        return password != null && password.length() > MINIMUM_PASSWORD_LENGTH;
    }

    private boolean doesPasswordHaveUppercase(String password) {
        char ch;
        boolean hasUpper = false;

        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
                break;
            }
        }

        return hasUpper;
    }

    private boolean doesPasswordContainSpecialCharacters(String password) {
        char ch;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (SPECIAL_CHARACTERS_LIST.contains(ch)) {
                hasSpecialChar = true;
                break;
            }
        }

        return hasSpecialChar;
    }
}
