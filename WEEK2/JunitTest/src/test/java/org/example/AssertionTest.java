package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssertionTest {
    @Test
    public void testAssertions() {
        // Assert that two strings are equal
       Assertions.assertEquals("Hello", "Hel" + "lo", "Strings should match");

        // Assert that a number is greater than another
        Assertions.assertTrue(10 > 7, "10 should be greater than 7");

        // Assert that a condition is false
        Assertions.assertFalse("Java".isEmpty(), "String should not be empty");

        // Assert that a variable is null
        String value = null;
        Assertions.assertNull(value, "Value should be null");

        // Assert that an array is not null
        int[] numbers = new int[]{1, 2, 3};
        Assertions.assertNotNull(numbers, "Array should not be null");
    }
}