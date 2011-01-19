package com.example;

import android.test.ActivityInstrumentationTestCase2;

public class CalculatorActivityTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {
    private UIDriver uiDriver;

    public CalculatorActivityTest() {
        super("com.example", CalculatorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        uiDriver = new UIDriver(getActivity());
    }

    public void testInitialDisplayShowsZero() throws InterruptedException {
        uiDriver.displayShows("0.");
    }

    public void testPressingNumberButtonShowsNumberInDisplay() throws InterruptedException {
        uiDriver.pressButtonWithId(R.id.BUTTON_1);
        uiDriver.displayShows("1.");
    }

    public void testPressingOnePlusOneEqualsShowsTwoInDisplay() throws InterruptedException {
        uiDriver.pressButtonWithId(R.id.BUTTON_1);
        uiDriver.displayShows("1.");
        uiDriver.pressButtonWithId(R.id.BUTTON_PLUS);
        uiDriver.displayShows("1.");
        uiDriver.pressButtonWithId(R.id.BUTTON_1);
        uiDriver.displayShows("1.");
        uiDriver.pressButtonWithId(R.id.BUTTON_EQUALS);
        uiDriver.displayShows("2.");
    }

    public void testPressingOnePlusTwoEqualsShowsThreeInDisplay() throws InterruptedException {
        uiDriver.pressButtonWithId(R.id.BUTTON_1);
        uiDriver.displayShows("1.");
        uiDriver.pressButtonWithId(R.id.BUTTON_PLUS);
        uiDriver.displayShows("1.");
        uiDriver.pressButtonWithId(R.id.BUTTON_2);
        uiDriver.displayShows("2.");
        uiDriver.pressButtonWithId(R.id.BUTTON_EQUALS);
        uiDriver.displayShows("3.");
    }

}
