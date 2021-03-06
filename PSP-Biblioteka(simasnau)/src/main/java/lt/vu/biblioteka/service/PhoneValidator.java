package main.java.lt.vu.biblioteka.service;

import main.java.lt.vu.biblioteka.model.Country;

import java.util.List;

public class PhoneValidator {

    public PhoneValidator() {
    }

    public boolean isPhoneValid(String phoneNumber, List<Country> countryList) {
        String normalizedPhoneNumber = normalizePhoneNumber(phoneNumber);
        if (normalizedPhoneNumber != null) {
            return onlyNumbersInPhoneNumber(normalizedPhoneNumber) && isPhoneNumberValidByCountry(normalizedPhoneNumber, countryList);
        } else {
            return phoneNumber != null && onlyNumbersInPhoneNumber(phoneNumber) && isPhoneNumberValidByCountry(phoneNumber, countryList);
        }
    }

    private String normalizePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.startsWith("8")) {
            return "+370" + phoneNumber.substring(1);
        }
        return null;
    }

    private boolean onlyNumbersInPhoneNumber(String phoneNumber) {
        String numberToValidate = phoneNumber;

        if (numberToValidate.startsWith("+")) {
            numberToValidate = numberToValidate.substring(1);
        }

        return numberToValidate.chars().allMatch(Character::isDigit);
    }

    private boolean isPhoneNumberValidByCountry(String phoneNumber, List<Country> countryList) {
        if (!countryList.isEmpty()) {
            for (Country country : countryList) {
                if (phoneNumber.length() == country.getLength() && phoneNumber.startsWith(country.getPrefix())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
