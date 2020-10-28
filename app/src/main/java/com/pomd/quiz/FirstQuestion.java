package com.pomd.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstQuestion extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.pomd.quiz.MESSAGE";
    boolean answer;
    int points = 0;
    String spoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);




        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }
    public void Arrow(View view){
        Intent intent = new Intent(FirstQuestion.this, SecondQuestion.class);
        TextView pnt = (TextView) findViewById(R.id.textView10);
        String message = pnt.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Button button;

        switch (v.getId()){
            case R.id.button2:
                button = (Button)findViewById(R.id.button2);
                button.setBackgroundColor(Color.GRAY);
                button.setEnabled(false);
                answer = false;
                button = (Button)findViewById(R.id.button3);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button4);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button5);
                button.setEnabled(false);
                break;
            case R.id.button3:
                button = (Button)findViewById(R.id.button3);
                button.setBackgroundColor(Color.GRAY);
                button.setEnabled(false);
                answer = false;
                button = (Button)findViewById(R.id.button2);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button4);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button5);
                button.setEnabled(false);
                break;
            case R.id.button4:
                button = (Button)findViewById(R.id.button4);
                button.setBackgroundColor(Color.GRAY);
                button.setEnabled(false);
                answer = true;
                button = (Button)findViewById(R.id.button3);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button2);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button5);
                button.setEnabled(false);
                break;
            case R.id.button5:
                button = (Button)findViewById(R.id.button5);
                button.setBackgroundColor(Color.GRAY);
                button.setEnabled(false);
                answer = false;
                button = (Button)findViewById(R.id.button3);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button4);
                button.setEnabled(false);
                button = (Button)findViewById(R.id.button2);
                button.setEnabled(false);
                break;
            case R.id.button6:
                if(answer == true){
                    TextView tv = findViewById(R.id.textView4);
                    tv.setTextColor(Color.GREEN);
                    tv.setText("Correct!");
                    tv.setVisibility(View.VISIBLE);
                    button=(Button)findViewById(R.id.button8);
                    button.setVisibility(View.VISIBLE);
                    button.setEnabled(true);
                    points = points + 5;
                    spoints = Integer.toString(points);
                    TextView textView = (TextView) findViewById(R.id.textView10);
                    textView.setText(spoints);
                }
                else if(answer == false){
                    TextView tv = findViewById(R.id.textView4);
                    tv.setTextColor(Color.RED);
                    tv.setText("Not correct!");
                    tv.setVisibility(View.VISIBLE);
                    points--;
                    spoints = Integer.toString(points);
                    TextView textView = (TextView) findViewById(R.id.textView10);
                    textView.setText(spoints);
                }
                break;

            case R.id.button7:
                button = (Button)findViewById(R.id.button5);
                button.setBackgroundColor(Color.WHITE);
                button.setEnabled(true);
                button = (Button)findViewById(R.id.button4);
                button.setBackgroundColor(Color.WHITE);
                button.setEnabled(true);
                button = (Button)findViewById(R.id.button3);
                button.setBackgroundColor(Color.WHITE);
                button.setEnabled(true);
                button = (Button)findViewById(R.id.button2);
                button.setBackgroundColor(Color.WHITE);
                button.setEnabled(true);
                TextView tv = findViewById(R.id.textView4);
                tv.setVisibility(View.INVISIBLE);
                answer = false;

                break;


        }


    }

}


