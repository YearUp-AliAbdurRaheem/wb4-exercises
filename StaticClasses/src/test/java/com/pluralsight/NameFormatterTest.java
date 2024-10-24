package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    String firstName;
    String middleName;
    String lastName;
    String prefix;
    String suffix;

    @BeforeEach
    public void setUp() {
        // Initialize the variables with default values before each test
        firstName = "John";
        middleName = "A";
        lastName = "Doe";
        prefix = "Dr.";
        suffix = "PhD";
    }

//    @Test
//    public void  {
//
//    }



    // First / Last Tests
    @Test
    public void testFormatFirstAndLastName() {
        String formattedName = NameFormatter.format(firstName, lastName);
        assertEquals("Doe, John", formattedName);
    }

    @Test
    public void testFormatFirstAndLastNameWithWhitespace() {
        String formattedName = NameFormatter.format( " " + firstName + "  ", "  " + lastName + "  ");
        assertEquals("Doe, John", formattedName);
    }

    @Test
    public void testFormatFirstNameAndEmptyLastName() {
        String formattedName = NameFormatter.format(firstName, "");
        assertEquals(firstName, formattedName);
    }

    @Test
    public void testFormatEmptyFirstNameAndLastName() {
        String formattedName = NameFormatter.format("", lastName);
        assertEquals(lastName, formattedName);
    }

    @Test
    public void testFormatFirstNameAndLastNameWithLongNamesJustLikeHowThisMethodHasAReallyReallyReallyLongName() { // This one was just for fun
        String formattedName = NameFormatter.format("Supercalifragilisticexpialidocious", "Pneumonoultramicroscopicsilicovolcanoconiosis");
        assertEquals("Pneumonoultramicroscopicsilicovolcanoconiosis, Supercalifragilisticexpialidocious", formattedName);
    }


    // Full Name Tests
    @Test
    public void testFormatFullNameWithAllComponents() {
        String formattedName = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);
        assertEquals("John, Dr. Doe A, PhD", formattedName);
    }

    @Test
    public void testFormatFullNameWithoutMiddleName() {
        String formattedName = NameFormatter.format(prefix, firstName,  "", lastName, suffix);
        assertEquals("John, Dr. Doe A, PhD", formattedName);
    }

    @Test
    public void testFormatFullNameWithoutSuffix() {
        String formattedName = NameFormatter.format(prefix, firstName,  middleName, lastName, "");
        assertEquals("John, Dr. Doe A", formattedName);
    }

    @Test
    public void testFormatFullNameWithoutPrefix() {
        String formattedName = NameFormatter.format("", firstName,  middleName, lastName, suffix);
        assertEquals("John, Doe A, PhD", formattedName);
    }

    @Test
    public void testFormatFullNameWithPrefixSuffix() {
        String formattedName = NameFormatter.format(prefix + ' ' + firstName + ' ' + middleName + ' ' + lastName + ", " + suffix);
        assertEquals("John, Dr. Doe A, PhD", formattedName);
    }

    @Test
    public void testFormatFullNameWithoutMiddleNameOneVariable() {
        String formattedName = NameFormatter.format(prefix + ' ' + firstName + ' ' + lastName + ", " + suffix);
        assertEquals("John, Dr. Doe, PhD", formattedName);
    }

    @Test
    public void testFormatFullNameWithoutSuffixOneVariable() {
        String formattedName = NameFormatter.format(prefix + ' ' + firstName + ' ' + middleName + ' ' + lastName);
        assertEquals("John, Dr. Doe A", formattedName);
    }

    @Test
    public void testFormatFullNameWithoutPrefixOneVariable() {
        String formattedName = NameFormatter.format(firstName + ' ' + middleName + ' ' + lastName + ", " + suffix);
        assertEquals("John, Doe A, PhD", formattedName);
    }

    @Test
    public void testFormatFullNameWithOnlyFirstAndLastName() {
        String formattedName = NameFormatter.format(firstName + lastName);
        assertEquals("John, Doe", formattedName);
    }

    @Test
    public void  testFormatFullNameWithOnlyLastName() {
        String formattedName = NameFormatter.format(firstName + lastName);
        assertEquals("John", formattedName);
    }

    @Test
    public void testFormatFullNameWithMultipleSpaces() {
        String formattedName = NameFormatter.format("  " +prefix + "    " + firstName + "   " + middleName + "  " + lastName + ",   " + suffix + " ");
        assertEquals("John, Dr. Doe A, PhD", formattedName);
    }
    


}