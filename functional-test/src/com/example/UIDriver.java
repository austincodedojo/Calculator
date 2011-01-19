package com.example;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class UIDriver {
    private Activity activity;

    public UIDriver(Activity activity) {
        this.activity = activity;
    }

    public void pressButtonWithId(final int buttonId) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                Button button = (Button) activity.findViewById(buttonId);

                button.performClick();
            }
        });
    }

    public void displayShows(String expectedText) throws InterruptedException {
        final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                TextView tv = (TextView) activity.findViewById(R.id.DISPLAY);

                queue.offer(tv.getText().toString());
            }
        });
        String actualText = queue.poll(1, TimeUnit.SECONDS);
        assertEquals(expectedText, actualText);
    }
}
