package main.java.lt.vu.biblioteka.service;

import main.java.lt.vu.biblioteka.model.Country;
import main.java.lt.vu.biblioteka.model.NormalizedPhoneNumber;

import java.util.List;

public class PhoneValidator {

    public PhoneValidator() {
    }

    public boolean isPhoneValid(String phoneNumber, List<Country> countryList) {
        NormalizedPhoneNumber normalizedPhoneNumber = normalizePhoneNumber(phoneNumber);
        if (normalizedPhoneNumber != null) {
            return onlyNumbersInPhoneNumber(normalizedPhoneNumber.getPhoneNumber()) && isPhoneNumberValidByCountry(phoneNumber, countryList);
        } else {
            return phoneNumber != null && onlyNumbersInPhoneNumber(phoneNumber) && isPhoneNumberValidByCountry(phoneNumber, countryList);
        }
    }

    private NormalizedPhoneNumber normalizePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.startsWith("+370")) {
            return new NormalizedPhoneNumber("8" + phoneNumber.substring(4), "+370", phoneNumber.length());
        }
        return null;
    }

    private boolean onlyNumbersInPhoneNumber(String phoneNumber) {
        char ch;

        for (int i = 0; i < phoneNumber.length(); i++) {
            ch = phoneNumber.charAt(i);
            if (!Character.isDigit(ch) && !phoneNumber.startsWith("+")) {
                return false;
            }
        }
        return true;
    }

    private boolean isPhoneNumberValidByCountry(Object phoneNumber, List<Country> countryList) {
        if (!countryList.isEmpty()) {
            for (Country country : countryList) {
                if (phoneNumber instanceof NormalizedPhoneNumber) {
                    NormalizedPhoneNumber number = (NormalizedPhoneNumber) phoneNumber;
                    if (number.getFullLength() == country.getLength() && number.getCountryPrefix().equals(country.getPrefix())) {
                        return true;
                    }
                } else if (phoneNumber instanceof String) {
                    String number = (String) phoneNumber;
                    if (number.length() == country.getLength() && number.startsWith(country.getPrefix())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
