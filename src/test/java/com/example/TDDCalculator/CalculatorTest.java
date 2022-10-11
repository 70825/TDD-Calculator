package com.example.TDDCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator("3 + 5 - 2 *  3 / 4");
    }
    @Test
    public void formulaTest() {
        setup();
    }
}