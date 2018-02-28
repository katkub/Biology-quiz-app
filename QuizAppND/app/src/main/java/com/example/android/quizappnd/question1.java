package com.example.android.quizappnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class question1 extends AppCompatActivity {

    //Necessary to calculate points//
    List<Integer> points;
    int score;
    int numberofquestions = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        //Necessary to calculate points//
        points = new ArrayList<Integer>();
        for (int index = 0; index < numberofquestions; index++) {
            points.add(index, 0);
        }

        //Passing editText value to this activity//
        final TextView textView = (TextView) findViewById(R.id.pName);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        textView.setText(str);

        //Sending editText value and score value to next activity//
        final Button next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Necessary to calculate and send points//
                for (int index = 0; index < points.size(); index++) {
                    score = score + points.get(index);
                }

                Intent intent = new Intent(question1.this, question2.class);
                intent.putExtra("name", textView.getText().toString());
                intent.putExtra("pointsQuestion1", score);
                score = 0;
                Toast.makeText(getApplicationContext(), "Nice! Now, next page!", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        });
    }
    //Calculate totalPoints based on checked answers//

    public List<Integer> onRadioButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.answerA1:
                points.set(0, 0);
                break;
            case R.id.answerB1:
                points.set(0, 0);
                break;
            case R.id.answerC1:
                points.set(0, 1);
                break;
            case R.id.answerA2:
                points.set(1, 0);
                break;
            case R.id.answerB2:
                points.set(1, 1);
                break;
            case R.id.answerC2:
                points.set(1, 0);
                break;
            case R.id.answerA3:
                points.set(2, 1);
                break;
            case R.id.answerB3:
                points.set(2, 0);
                break;
            case R.id.answerC3:
                points.set(2, 0);
                break;
            case R.id.answerA4:
                points.set(3, 0);
                break;
            case R.id.answerB4:
                points.set(3, 0);
                break;
            case R.id.answerC4:
                points.set(3, 1);
                break;
            case R.id.answerA5:
                points.set(4, 1);
                break;
            case R.id.answerB5:
                points.set(4, 0);
                break;
            case R.id.answerC5:
                points.set(4, 0);
                break;
            case R.id.answerA6:
                points.set(5, 0);
                break;
            case R.id.answerB6:
                points.set(5, 1);
                break;
            case R.id.answerC6:
                points.set(5, 0);
                break;
        }
        return points;
    }
}
