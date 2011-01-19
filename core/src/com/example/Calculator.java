package com.example;

public class Calculator {
    private UI ui;
    private int operand;
    private int lastOperand;

    public Calculator(UI ui) {
        this.ui = ui;
        ui.updateDisplay("0.");
    }

    public void pressButton(String buttonLabel) {
        if(Character.isDigit(buttonLabel.charAt(0))) {
            operand = Integer.parseInt(buttonLabel);
            ui.updateDisplay(buttonLabel + ".");
        }
        else if(buttonLabel.equals("=")) {
            operand += lastOperand;
            ui.updateDisplay(Integer.toString(operand) + ".");
        }
        else if(buttonLabel.equals("+")) {
            lastOperand = operand;
        }
    }
}
