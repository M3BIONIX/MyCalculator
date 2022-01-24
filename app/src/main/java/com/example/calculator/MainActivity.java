package com.example.calculator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView outputext;
    private TextView outputext1;

    double finalans = 0;
    double number = 0,temp=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById((R.id.button1));
        Button button2 = findViewById((R.id.button2));
        Button button3 = findViewById((R.id.button3));
        Button button4 = findViewById((R.id.button4));
        Button button5 = findViewById((R.id.button5));
        Button button6 = findViewById((R.id.button6));
        Button button7 = findViewById((R.id.button7));
        Button button8 = findViewById((R.id.button8));
        Button button9 = findViewById((R.id.button9));
        Button button0 = findViewById((R.id.button0));
        Button plus = findViewById((R.id.plus));
        Button minus = findViewById((R.id.minus));
        Button multiply = findViewById((R.id.multiply));
        Button divide = findViewById((R.id.divide));
        Button equal = findViewById(R.id.equal);
        Button back = findViewById(R.id.back);
        Button clear = findViewById(R.id.clear);

        outputext = findViewById((R.id.textView2));
        outputext1 = findViewById((R.id.textView));
        outputext.setText("");
        outputext1 .setTextColor(Color.parseColor("#FFFFFF"));
        outputext.setTextColor(Color.parseColor("#FFFFFF"));
        button1.setOnClickListener(view -> assign(1));
            button2.setOnClickListener(view -> assign(2));
            button3.setOnClickListener(view -> assign(3));
            button4.setOnClickListener(view -> assign(4));
            button5.setOnClickListener(view -> assign(5));
            button6.setOnClickListener(view -> assign(6));
            button7.setOnClickListener(view -> assign(7));
            button8.setOnClickListener(view -> assign(8));
            button9.setOnClickListener(view -> assign(9));
            button0.setOnClickListener(view -> forzero());
            plus.setOnClickListener(view -> {
                   if(finalans != 0)
                       number = finalans;
                   outputext.setText("");
                   outputext1.setText(number + " +");
                   temp = number;
                   number = 0;

                   String text = outputext1.getText().toString();
                   calculate(text);

                });

            minus.setOnClickListener(view -> {
                if(finalans != 0)
                    number = finalans;
                outputext1.setText(number + " -");
                temp = number;
                number = 0;
                String text = outputext1.getText().toString();
                calculate(text);
            });

            multiply.setOnClickListener(view -> {
                if(finalans != 0)
                    number = finalans;
                outputext.setText("");
                outputext1.setText(number + " x");
                temp = number;
                number = 0;

                String text = outputext1.getText().toString();
                calculate(text);

            });

            divide.setOnClickListener(view -> {
                if(finalans != 0)
                    number = finalans;
                outputext.setText("");
                outputext1.setText(number + " /");
                temp = number;
                number = 0;

                String text = outputext1.getText().toString();
                calculate(text);
            });

                    back.setOnClickListener(view -> {
                        number = (number - number%10)/10;
                        outputext.setText(String.valueOf(number));
                    });

            clear.setOnClickListener(view -> {
                number = 0;
                temp = 0;
                finalans = 0;
                outputext.setText("");
                outputext1.setText("");
            });

            equal.setOnClickListener(view -> {

                outputext.setText(String.valueOf(temp));
                String text = outputext1.getText().toString();
                calculate(text);
                outputext1.setText(outputext.getText().toString());
            });




        }



    private void assign(int var)
    {
        number = number*10 + var;
        outputext.setText(String.valueOf(number));
    }
    private void forzero()
    {
        number = number*10;
        outputext.setText(String.valueOf(number));

    }
    private void calculate(String text)
    {
        if(text.contains("+"))
           finalans  =  number+temp;
        if(text.contains("-"))
            finalans =  temp-number;
        if(text.contains("x"))
            finalans = temp*number;
        if(text.contains("/"))
            finalans = temp/number;
      outputext.setText(String.valueOf(finalans));
    }




}
