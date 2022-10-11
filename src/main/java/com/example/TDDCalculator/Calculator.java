package com.example.TDDCalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String formula;
    private List<Integer> integerList = new ArrayList<>();
    private List<String> operatorList = new ArrayList<>();

    public Calculator(String expression) {
        this.formula = expression;
    }

    public String getFormula() {
        return this.formula;
    }

    public List<Integer> getIntegerList() {
        return this.integerList;
    }

    public List<String> getOperatorList() {
        return this.operatorList;
    }

    public boolean validator() {
        boolean correctFlag = true;

        String[] formulaList = this.getFormula().split(" ");

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

    public int calculation() {
        String operator;
        int integer;

        int answer = integerList.get(0);

        for(int idx = 0; idx < operatorList.size(); idx++) {
            operator = operatorList.get(idx);
            integer = integerList.get(idx + 1);

            if (operator.equals("+")) {
                answer += integer;
            } else if (operator.equals("-")) {
                answer -= integer;
            } else if (operator.equals("*")) {
                answer *= integer;
            } else {
                answer /= integer;
            }
        }

        return answer;
    }
}
