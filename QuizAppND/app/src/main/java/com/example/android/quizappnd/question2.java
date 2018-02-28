package com.example.android.quizappnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class question2 extends AppCompatActivity {

    //Necessary to calculate points in this activity//
    int points2;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        //Passing editText value and score value from question1.class to this activity//
        final TextView textView = (TextView) findViewById(R.id.plName);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        textView.setText(str);
        final int points1 = getIntent().getIntExtra("pointsQuestion1", 1);

        //Initialize the CheckBoxes//
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        cb4 = (CheckBox) findViewById(R.id.checkbox4);
        cb5 = (CheckBox) findViewById(R.id.checkbox5);
        cb6 = (CheckBox) findViewById(R.id.checkbox6);

        //Sending editText value and score values from question1/2.class to next activity//
        final Button next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Adding points for correect checkbox answers, and incorrect unchecked//
                if (cb1.isChecked() && cb3.isChecked() && cb4.isChecked() && !cb2.isChecked() && !cb5.isChecked() && !cb6.isChecked()) {
                    points2 = points2 + 3;
                }
                if (cb1.isChecked() && cb3.isChecked() && !cb4.isChecked() && !cb2.isChecked() && !cb5.isChecked() && !cb6.isChecked()) {
                    points2 = points2 + 2;
                }
                if (cb1.isChecked() && cb4.isChecked() && !cb3.isChecked() && !cb2.isChecked() && !cb5.isChecked() && !cb6.isChecked()) {
                    points2 = points2 + 2;
                }
                if (cb1.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb2.isChecked() && !cb5.isChecked() && !cb6.isChecked()) {
                    points2 = points2 + 1;
                }
                if (!cb1.isChecked() && cb3.isChecked() && !cb4.isChecked() && !cb2.isChecked() && !cb5.isChecked() && !cb6.isChecked()) {
                    points2 = points2 + 1;
                }
                if (!cb1.isChecked() && !cb3.isChecked() && cb4.isChecked() && !cb2.isChecked() && !cb5.isChecked() && !cb6.isChecked()) {
                    points2 = points2 + 1;
                }

                Intent intent = new Intent(question2.this, question3.class);
                intent.putExtra("name", textView.getText().toString());
                intent.putExtra("pointsQuestion1", points1);
                intent.putExtra("pointsQuestion2", points2);
                Toast.makeText(getApplicationContext(), "Great! Next!", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        });
    }
}

