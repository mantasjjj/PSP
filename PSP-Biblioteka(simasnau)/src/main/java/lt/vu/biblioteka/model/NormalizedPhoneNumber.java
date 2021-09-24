package main.java.lt.vu.biblioteka.model;

public class NormalizedPhoneNumber {

    String phoneNumber;
    String countryPrefix;
    int fullLength;

    public NormalizedPhoneNumber(String phoneNumber, String countryPrefix, int fullLength) {
        this.phoneNumber = phoneNumber;
        this.countryPrefix = countryPrefix;
        this.fullLength = fullLength;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountryPrefix() {
        return countryPrefix;
    }

    public int getFullLength() {
        return fullLength;
    }
}
