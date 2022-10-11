package com.example.TDDCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void formulaTest() {
        Calculator calculator = new Calculator("3 + 5 - 2 * 3 / 4");
    }

}