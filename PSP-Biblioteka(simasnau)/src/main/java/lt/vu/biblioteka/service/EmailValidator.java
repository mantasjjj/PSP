package main.java.lt.vu.biblioteka.service;

import java.util.Collections;
import java.util.List;

public class EmailValidator {

    private List<Character> illegalCharactersList = Collections.singletonList('#');

    public EmailValidator() {
    }

    public EmailValidator(List<Character> illegalChars) {
        this.illegalCharactersList = illegalChars;
    }

    public boolean isEmailValid(String email) {
        return email != null && atSignExists(email) && !emailContainsIllegalCharactersSpecialCharacters(email) && emailHasValidDomain(email);
    }

    private boolean atSignExists(String email) {
        char ch;
        boolean hasAtSign = false;

        for (int i = 0; i < email.length(); i++) {
            ch = email.charAt(i);
            if (ch == '@') {
                hasAtSign = true;
                break;
            }
        }

        return hasAtSign;
    }

    private boolean emailContainsIllegalCharactersSpecialCharacters(String email) {
        char ch;

        for (int i = 0; i < email.length(); i++) {
            ch = email.charAt(i);
            if (illegalCharactersList.contains(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean emailHasValidDomain(String email) {
        char ch;
        String domain;
        String domainName;

        for (int i = 0; i < email.length(); i++) {
            ch = email.charAt(i);
            if (ch == '@') {
                domain = email.substring(i + 1);
                domainName = email.substring(0, domain.indexOf('.'));
                if (domainName.length() < 2 || domainName.length() > 63) {
                    return false;
                }
                if (!domain.contains(".")) {
                    return false;
                }
            }
        }

        return true;
    }
}
