package com.example.gregory.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int num;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(num);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;
            } else {

                return false;
            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNum = 1;

            while (triangularNum < num) {

                x++;

                triangularNum = triangularNum + x;

            }

            if (triangularNum == num) {

                return true;
            } else {

                return false;
            }

        }
    }

    public void testNumber(View view) {

        String message = "";

        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);

        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter a number!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        } else {

            Log.i("usersNumber", usersNumber.getText().toString());

            Number myNum = new Number();

            myNum.num = Integer.parseInt(usersNumber.getText().toString());


            if (myNum.isSquare()) {

                if (myNum.isTriangular()) {

                    message = myNum.num + " is both triangular and square!";
                } else {
                    message = myNum.num + " is Square, but not triangular.";
                }
            } else {

                if (myNum.isTriangular()) {

                    message = myNum.num + " is triangular but not square!";
                } else {
                    message = myNum.num + " is neither square nor triangular!";
                }
            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            System.out.println(myNum.isSquare());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
