package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity implements UI {
    private Calculator calculator;
    private TextView display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        display = (TextView) findViewById(R.id.DISPLAY);
        calculator = new Calculator(this);

        configureButton(R.id.BUTTON_1, "1");
        configureButton(R.id.BUTTON_2, "2");
        configureButton(R.id.BUTTON_PLUS, "+");
        configureButton(R.id.BUTTON_EQUALS, "=");
    }

    private void configureButton(int buttonId, final String buttonLabel) {
        Button buttonOne = (Button) findViewById(buttonId);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculator.pressButton(buttonLabel);
            }
        });
    }

    public void updateDisplay(String updatedText) {
        display.setText(updatedText);
    }
}
