package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {}

    public static String format(String firstName, String lastName) {
        if (firstName.isBlank()) {
            return lastName;
        }
        if (lastName.isBlank()) {
            return firstName;
        }
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        return "";
    }

    public static String format(String fullName) {
        return "";
    }
}
