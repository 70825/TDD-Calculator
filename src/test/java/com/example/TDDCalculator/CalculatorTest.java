package com.example.TDDCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator("31 + 55 - 2 * 3 / 4");
    }
    @Test
    public void formulaTest() {
    }

    @Test
    public void getFormulaTest() {
        assertEquals("31 + 55 - 2 * 3 / 4", calculator.getFormula());
    }

    @Test
    public void validatorTest() {
        boolean testCorrectFlag;

        testCorrectFlag = calculator.validator();
        assertTrue(testCorrectFlag);

        Calculator calculator1 = new Calculator("1 + 2 + +");
        testCorrectFlag = calculator1.validator();
        assertFalse(testCorrectFlag);

        Calculator calculator2 = new Calculator("30 10 10");
        testCorrectFlag = calculator2.validator();
        assertFalse(testCorrectFlag);
    }

    @Test
    public void splitIntegerTest() {
        calculator.validator();

        assertEquals(Arrays.asList(31, 55, 2, 3, 4), calculator.getIntegerList());
    }

    @Test
    public void splitOperatorTest() {
        calculator.validator();

        assertEquals(Arrays.asList("+", "-", "*", "/"), calculator.getOperatorList());
    }
}