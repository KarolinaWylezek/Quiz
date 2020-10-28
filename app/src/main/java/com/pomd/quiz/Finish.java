package com.pomd.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent = getIntent();
        String getPoints = intent.getStringExtra(FourthQuestion.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView12);
        textView.setText(getPoints);
    }
}