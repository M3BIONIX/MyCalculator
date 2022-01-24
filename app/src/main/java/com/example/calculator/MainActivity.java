package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button equal;
    private Button plus;
    private Button minus;
    private Button divide;
    private Button multiply;
    private TextView outputext;
    private TextView outputext1;
    private Button clear;

    double finalans = 0;
    private Button back;
    double number = 0,temp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById((R.id.button1));
        button2 = findViewById((R.id.button2));
        button3 = findViewById((R.id.button3));
        button4 = findViewById((R.id.button4));
        button5 = findViewById((R.id.button5));
        button6 = findViewById((R.id.button6));
        button7= findViewById((R.id.button7));
        button8 = findViewById((R.id.button8));
        button9 = findViewById((R.id.button9));
        button0 = findViewById((R.id.button0));
        plus = findViewById((R.id.plus));
        minus = findViewById((R.id.minus));
        multiply = findViewById((R.id.multiply));
        divide = findViewById((R.id.divide));
        equal = findViewById(R.id.equal);
        back = findViewById(R.id.back);
        clear = findViewById(R.id.clear);

        outputext = findViewById((R.id.textView2));
        outputext1 = findViewById((R.id.textView));
        outputext.setText("");

        button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(1);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(2);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(3);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(4);
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(5);
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(6);
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(7);
                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(8);
                }
            });
            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    assign(9);
                }
            });
            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    forzero();
                }
            });
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                       if(finalans != 0)
                           number = finalans;
                       outputext.setText("");
                       outputext1.setText(String.valueOf(number + " +"));
                       temp = number;
                       number = 0;

                       String text = outputext1.getText().toString();
                       calculate(text);

                    }
            });

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalans != 0)
                        number = finalans;
                    outputext1.setText(String.valueOf(number+" -"));
                    temp = number;
                    number = 0;
                    String text = outputext1.getText().toString();
                    calculate(text);
                }
            });

            multiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalans != 0)
                        number = finalans;
                    outputext.setText("");
                    outputext1.setText(String.valueOf(number + " x"));
                    temp = number;
                    number = 0;

                    String text = outputext1.getText().toString();
                    calculate(text);

                }
            });

            divide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalans != 0)
                        number = finalans;
                    outputext.setText("");
                    outputext1.setText(String.valueOf(number + " /"));
                    temp = number;
                    number = 0;

                    String text = outputext1.getText().toString();
                    calculate(text);
                }
            });

                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            number = (number - number%10)/10;
                            outputext.setText(String.valueOf(number));
                        }
                    });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    number = 0;
                    temp = 0;
                    finalans = 0;
                    outputext.setText("");
                    outputext1.setText("");
                }
            });

            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    outputext.setText(String.valueOf(temp));

                    String text = outputext1.getText().toString();
                    calculate(text);
                    outputext1.setText(outputext.getText().toString());
                }

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
