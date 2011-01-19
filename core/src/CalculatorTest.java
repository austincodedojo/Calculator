import com.example.Calculator;
import com.example.UI;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;
    private UI ui;
    private String updatedDisplay;

    @Before
    public void setup() {
        calculator = new Calculator(new UI() {
            public void updateDisplay(String updatedText) {
                updatedDisplay = updatedText;
            }
        });
    }

    @Test
    public void shouldInitiallyShowZero() {
        assertEquals("0.", updatedDisplay);
    }

    @Test
    public void shouldShowDigitInDisplayWhenDigitIsPressed() {
        calculator.pressButton("1");
        assertEquals("1.", updatedDisplay);
    }

    @Test
    public void shouldNotChangeDigitWhenOperatorIsPressed() {
        calculator.pressButton("1");
        calculator.pressButton("+");
        assertEquals("1.", updatedDisplay);
    }

    @Test
    public void shouldChangeDigitWhenDigitButtonIsPressedAfterOperator() {
        calculator.pressButton("1");
        calculator.pressButton("+");
        calculator.pressButton("2");
        assertEquals("2.", updatedDisplay);
    }

    @Test
    public void shouldPerformCalculationWhenEqualPressed() {
        calculator.pressButton("1");
        calculator.pressButton("+");
        calculator.pressButton("2");
        calculator.pressButton("=");
        assertEquals("3.", updatedDisplay);
    }
}
