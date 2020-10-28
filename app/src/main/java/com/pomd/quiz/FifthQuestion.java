package com.pomd.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FifthQuestion extends AppCompatActivity implements View.OnClickListener {
boolean button1 = true;
boolean button2 = false;
boolean button3 = true;
boolean button4 = false;
boolean button5 = true;

    public static final String EXTRA_MESSAGE = "com.pomd.quiz.MESSAGE";
    int points;
    String spoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_question);

        Intent intent = getIntent();
        String getPoints = intent.getStringExtra(FourthQuestion.EXTRA_MESSAGE);
        points = Integer.parseInt(getPoints);

        Switch sw1 = (Switch) findViewById(R.id.switch1);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button1 = false;
                }
            }
            });

            Switch sw2 = (Switch) findViewById(R.id.switch2);
            sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button2 = true;
                }
            }
        });
        Switch sw3 = (Switch) findViewById(R.id.switch3);
        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button3 = false;
                }
            }
        });
        Switch sw4 = (Switch) findViewById(R.id.switch4);
        sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button4 = true;
                }
            }
        });
        Switch sw5 = (Switch) findViewById(R.id.switch5);
        sw5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button5 = false;
                }
            }
        });


        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);

        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

            }

    @Override
    public void onClick(View v) {
        Switch sw;
        Button button;

        switch (v.getId()){

            case R.id.button6:
                sw = (Switch) findViewById(R.id.switch1);
                sw.setEnabled(false);
                sw = (Switch) findViewById(R.id.switch2);
                sw.setEnabled(false);
                sw = (Switch) findViewById(R.id.switch3);
                sw.setEnabled(false);
                sw = (Switch) findViewById(R.id.switch4);
                sw.setEnabled(false);
                sw = (Switch) findViewById(R.id.switch5);
                sw.setEnabled(false);

                if((button1 & button2 & button3 & button4 & button5) == true){
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
                else if((button1 & button2 & button3 & button4 & button5) == false){
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
                sw = (Switch) findViewById(R.id.switch1);
                sw.setEnabled(true);
                sw = (Switch) findViewById(R.id.switch2);
                sw.setEnabled(true);
                sw = (Switch) findViewById(R.id.switch3);
                sw.setEnabled(true);
                sw = (Switch) findViewById(R.id.switch4);
                sw.setEnabled(true);
                sw = (Switch) findViewById(R.id.switch5);
                sw.setEnabled(true);
                TextView tv = findViewById(R.id.textView4);
                tv.setVisibility(View.INVISIBLE);
                button1 = true;
                button2 = false;
                button3 = true;
                button4 = false;
                button5 = true;

                break;

        }


    }
    public void Arrow(View view){
        Intent intent = new Intent(FifthQuestion.this, Finish.class);
        TextView pnt = (TextView) findViewById(R.id.textView10);
        String message = pnt.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
