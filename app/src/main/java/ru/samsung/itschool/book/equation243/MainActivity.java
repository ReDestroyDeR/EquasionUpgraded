package ru.samsung.itschool.book.equation243;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
        public void solveEquation(View view) {
             // ax+b=c
            double a = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_a)).getText().toString());
            double b = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_b)).getText().toString());
            double c = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_c)).getText().toString());
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("" + String.valueOf((c - b) / a));
        }

        // Solving double square equasion through D
        public void solveDoubleEquasion(View view) {
            // get cf's
            // KFC :ROFLAN_ZDAROVA:
            double a = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_a2)).getText().toString());
            double b = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_b2)).getText().toString());
            double c = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_c2)).getText().toString());

            /*
             * D = b^2 - 4ac
             *
             * D>0 - 2
             * D=0 - 1
             * D<0 - 0
            */

            double D = b*b - 4*a*c; // General formula for D
            double x = 0.0;
            double x2 = 0.0;

            boolean plusMinus = false; // For x index 1 and x index 2
            boolean exception = false; // If D less than zero

            String resultString = "";

            // Checking for simple equasion
            if (a!=0) {
                // Checking D values
                if (D>0) {
                    x = (Math.sqrt(D)-b)/(2*a);
                    x2 = (-Math.sqrt(D)-b)/(2*a);
                    plusMinus = true;
                } else if (D==0) {
                    x = (Math.sqrt(D)-b)/(2*a);
                } else {
                    exception = true;
                }

                // Boolean checks
                if (plusMinus) {
                    resultString = "x1 = " + x + "; x2 = " + x2;
                } else if (exception) {
                    resultString = "D less than zero";
                } else {
                    resultString = "x = " + x;
                }
            } else {
                // Here we are solving a simple equasion
                resultString = "x = " + String.valueOf(-c/b);
            }


            TextView result = (TextView) findViewById(R.id.result2);
            result.setText(resultString);

        }

}
