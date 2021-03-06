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

    /**
     * Вызывается при нажатии пользователем на кнопку Решить
     */
    public void solveEquation(View view) {
        // ax+b=c
        double a = Double.parseDouble(((EditText)
                findViewById(R.id.normalEq_coefficient_a)).getText().toString());
        double b = Double.parseDouble(((EditText)
                findViewById(R.id.normalEq_coefficient_b)).getText().toString());
        double c = Double.parseDouble(((EditText)
                findViewById(R.id.normalEq_coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);
        result.setText("" + String.valueOf((c - b) / a));
    }

    // Solving double square equasion through D
    public void solveDoubleEquasion(View view) {
        double a = Double.parseDouble(((EditText)
                findViewById(R.id.doubleEq_coefficient_a)).getText().toString());
        double b = Double.parseDouble(((EditText)
                findViewById(R.id.doubleEq_coefficient_b)).getText().toString());
        double c = Double.parseDouble(((EditText)
                findViewById(R.id.doubleEq_coefficient_c)).getText().toString());

        /*
         * D = b^2 - 4ac
         *
         * D>0 - 2
         * D=0 - 1
         * D<0 - 0
         */

        double D = b * b - 4 * a * c;
        double x = 0.0;
        double x2 = 0.0;

        boolean plusMinus = false;
        boolean exception = false;

        String resultString = "";
        if (a == 0) {
            resultString = "x = " + String.valueOf(-c / b);
        } else if (D > 0) {
            x = (Math.sqrt(D) - b) / (2 * a);
            x2 = (-Math.sqrt(D) - b) / (2 * a);
            resultString = "x1 = " + x + "; x2 = " + x2;
        } else if (D == 0) {
            x = (Math.sqrt(D) - b) / (2 * a);
            resultString = "x = " + x;
        } else {
            resultString = "D less than zero";
        }


        TextView result = (TextView) findViewById(R.id.normalEqResult);
        result.setText(resultString);

    }

}
