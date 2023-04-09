package com.example.calculator_tc.ui;

import com.example.calculator_tc.model.Calculator;
import com.example.calculator_tc.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {

    private final DecimalFormat formatter = new DecimalFormat("#.##");

    private final CalculatorView view;
    private final Calculator calculator;

    private double argOne;
    private Double argTwo;
    private Operator selectedOperator;
    private boolean onDotPressed = false;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed (int digit) {
        if (argTwo == null) {
            if (!onDotPressed) {
                argOne = argOne * 10 + digit;
                view.shouResult(String.valueOf(argOne));
            } else {
                argOne = argOne + digit / 10;
                showFormatted (argOne);
            }
        } else {
            if (onDotPressed == false) {
                argTwo = argTwo * 10 + digit;
                view.shouResult(String.valueOf(argTwo));
            } else {
                argTwo = argTwo + digit/10;
                showFormatted (argTwo);
            }

        }

    }

    public void onOperatorPressed(Operator operator) {
        if (selectedOperator != null) {
            argOne = calculator.perform(argOne, argTwo, selectedOperator);
            view.shouResult(String.valueOf(argOne));

        }
           argTwo = 0.0;

        selectedOperator = operator;
        onDotPressed = false;
    }

    public void onDotPressed() {
        onDotPressed = true;
    }

    private void showFormatted (double value) {
        view.shouResult(formatter.format(value));
    }
}
