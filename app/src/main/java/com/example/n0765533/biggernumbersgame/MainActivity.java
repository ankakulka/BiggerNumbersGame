package com.example.n0765533.biggernumbersgame;
import android.app.*;
import android.support.v7.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    private int num1;    // the numbers on the left and right buttons
    private int num2;
    private int num3;
    private int points;  // player's point total; initially 0

    /*
     * Called when the player clicks the left number button.
     */
    public void clickButton1(View view) {
        check(num2, num1, num3);
    }

    /*
     * Called when the player clicks the right number button.
     */
    public void clickButton2(View view) {
        check(num1, num2, num3);
    }
    private void check(int a, int b, int c) {
        if (b > a || b > c) {
            points++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }

        else {
            points--;
            Toast.makeText(this, "You are STUPID.", Toast.LENGTH_SHORT).show();
        }

        TextView pointsView = (TextView) findViewById(R.id.pointsTextView);
        pointsView.setText("Points: " + points);
        roll();
    }

    private void roll() {
        // pick two random numbers
        Random r = new Random();
        num1 = r.nextInt(20);
        num2 = r.nextInt(20);
        num3 = r.nextInt(20);
        while (num2 == num1 || num2 == num3 || num1 == num3) {
            num2 = r.nextInt(20);
        }

        // set the buttons to display the random numbers
        Button left = (Button) findViewById(R.id.buttonLeft);
        left.setText("" + num1);     // "" + int -> converts int to String

        Button right = (Button) findViewById(R.id.buttonRight);
        right.setText("" + num2);

        Button middle = (Button) findViewById(R.id.buttonMiddle);
        right.setText("" + num3);

    }


    /*
     * This method is called by Android when our activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll();
    }
}
