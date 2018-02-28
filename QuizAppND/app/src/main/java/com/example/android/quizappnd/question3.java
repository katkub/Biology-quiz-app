package com.example.android.quizappnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class question3 extends AppCompatActivity {

    //Necessary to calculate total points from this activity//
    int points3;
    int points4;
    int points5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        //Passing editText value and score value from question1/2.class to this activity//
        final TextView textView = (TextView) findViewById(R.id.plaName);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        textView.setText(str);
        final int points = getIntent().getIntExtra("pointsQuestion1", 1);
        final int points2 = getIntent().getIntExtra("pointsQuestion2", 1);

        //Sending editText value and score values from question1/2/3.class to next activity//
        final Button next3 = (Button) findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Calling method openPoint1/2/3//
                EditText editText1 = (EditText) findViewById(R.id.correctAnswer1);
                String input1 = editText1.getText().toString();
                openPoint1(input1);
                EditText editText2 = (EditText) findViewById(R.id.correctAnswer2);
                String input2 = editText2.getText().toString();
                openPoint2(input2);
                EditText editText3 = (EditText) findViewById(R.id.correctAnswer3);
                String input3 = editText3.getText().toString();
                openPoint3(input3);

                Intent intent = new Intent(question3.this, totalPoints.class);
                intent.putExtra("name", textView.getText().toString());
                final int total = points + points2 + points3 + points4 + points5;
                intent.putExtra("totalPoints", total);
                Toast.makeText(getApplicationContext(), "Calculating points...", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        });
    }

    // Calculate points based on answer player wrote in EditText1//
    private int openPoint1(String input1) {

        switch (input1) {
            case "Nitrogen":
                points3 = points3 + 1;
                break;
            case "nitrogen":
                points3 = points3 + 1;
                break;
            case "NITROGEN":
                points3 = points3 + 1;
                break;
        }
        return points3;
    }

    // Calculate points based on answer player wrote in EditText2//
    private int openPoint2(String input2) {

        switch (input2) {
            case "Cytology":
                points4 = points4 + 1;
                break;
            case "cytology":
                points4 = points4 + 1;
                break;
            case "CYTOLOGY":
                points4 = points4 + 1;
                break;
        }
        return points4;
    }

    // Calculate points based on answer player wrote in EditText3//
    private int openPoint3(String input3) {

        switch (input3) {
            case "Melanocytes":
                points5 = points5 + 1;
                break;
            case "melanocytes":
                points5 = points5 + 1;
                break;
            case "MELANOCYTES":
                points5 = points5 + 1;
                break;
        }
        return points5;
    }
}
