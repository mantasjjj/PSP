package main.java.lt.vu.biblioteka.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailValidator {

    private List<Character> illegalCharactersList = new ArrayList<>(Arrays.asList('#', '$'));

    public EmailValidator() {
    }

    public EmailValidator(List<Character> illegalChars) {
        this.illegalCharactersList = illegalChars;
    }

    public boolean isEmailValid(String email) {
        return email != null && atSignExists(email) && !emailContainsIllegalCharactersSpecialCharacters(email) && emailHasValidDomain(email);
    }

    private boolean atSignExists(String email) {
        return email.chars().anyMatch(c -> c == '@');
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
        String domain = email.substring(email.indexOf('@'));
        String domainName = email.substring(0, domain.indexOf('.'));
        String tld = domain.substring(domain.lastIndexOf("."));
        return domainName.length() >= 2 && domainName.length() <= 63 &&
                domain.contains(".") && !domain.startsWith("-") && !domain.endsWith("-")
                && tld.length() >= 2 && tld.length() <= 6;
    }
}
