package com.example.TDDCalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String formula;

    public Calculator(String expression) {
        this.formula = expression;
    }

    public String getFormula() {
        return this.formula;
    }

    public boolean validator() {
        boolean correctFlag = true;

        String[] formulaList = this.getFormula().split(" ");
        List<Integer> integerList = new ArrayList<>();
        List<String> operatorList = new ArrayList<>();

        for(int idx = 0; idx < formulaList.length; idx++) {
            if (idx % 2 == 0) {
                try {
                    int integerValue = Integer.parseInt(formulaList[idx]);
                    integerList.add(integerValue);
                } catch (Exception e) {
                    correctFlag = false;
                }
            }
            else {
                String operator = formulaList[idx];
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                    operatorList.add(operator);
                } else {
                    correctFlag = false;
                }
            }
        }

        if (integerList.size() - operatorList.size() != 1) correctFlag = false;

        return correctFlag;
    }
}
