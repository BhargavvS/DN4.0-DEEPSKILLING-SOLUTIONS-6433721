package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // This runs before each test
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created.");
    }

    @AfterEach
    public void tearDown() {
        // This runs after each test
        calculator = null;
        System.out.println("Teardown: Calculator instance cleared.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result, "10 + 20 should be 30");
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 15;
        int b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(10, result, "15 - 5 should be 10");
    }

}