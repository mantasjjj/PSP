package main.java.lt.vu.biblioteka.model;

public class Country {
    private String name;
    private String prefix;
    private int length;

    public Country(String name, String prefix, int length) {
        this.name = name;
        this.prefix = prefix;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getLength() {
        return length;
    }
}
