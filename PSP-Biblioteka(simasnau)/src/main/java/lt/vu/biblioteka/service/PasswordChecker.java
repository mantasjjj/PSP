package main.java.lt.vu.biblioteka.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordChecker {
    private static final int MINIMUM_PASSWORD_LENGTH = 6;
    private List<Character> specialCharactersList = new ArrayList<>(Arrays.asList('#', '$'));

    public PasswordChecker() {
    }

    public PasswordChecker(List<Character> specialChars) {
        this.specialCharactersList = specialChars;
    }

    public boolean isPasswordValid(String password) {
        return isPasswordLengthValid(password) && doesPasswordHaveUppercase(password) && doesPasswordContainSpecialCharacters(password);
    }

    private boolean isPasswordLengthValid(String password) {
        return password != null && password.length() > MINIMUM_PASSWORD_LENGTH;
    }

    private boolean doesPasswordHaveUppercase(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    private boolean doesPasswordContainSpecialCharacters(String password) {
        char ch;

        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (specialCharactersList.contains(ch)) {
                return true;
            }
        }

        return false;
    }
}
