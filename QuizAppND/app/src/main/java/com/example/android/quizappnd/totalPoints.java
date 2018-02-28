package com.example.android.quizappnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class totalPoints extends AppCompatActivity {

    //Necessary to paste total points from quiz to textview//
    String comment;
    TextView commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_points);

        //Passing editText value and scoreTextView value to this activity//
        final TextView playerName = ( TextView ) findViewById(R.id.playerName);
        final TextView scores = ( TextView ) findViewById(R.id.scores);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        playerName.setText(str);
        String tPoints = String.valueOf(getIntent().getExtras().getInt("totalPoints"));
        scores.setText(tPoints);
        final int total = getIntent().getIntExtra("totalPoints", 1);


        //Calling the method calculateOfPoints() from here//
        calculateOfPoints(total, "comment");
        String comment = calculateOfPoints(total, "comment");

        //Putting results of method whichKindOfEmployee to textView//
        commentText = ( TextView ) findViewById(R.id.commentText);
        commentText.setText(comment);
        Toast.makeText(getApplicationContext(), "Total points: " + tPoints, Toast.LENGTH_LONG).show();
    }

    /**
     * This method is called when we want to add 'commentText' to message .
     *
     * @param addComment when we want to add comment based on scored points
     */

    private String calculateOfPoints(int points, String addComment) {
        if ((points > 0) && (points <= 6)) {
            comment = "\n" + "\n" + getString(R.string.bad);
        } else if ((12 > points) && (points > 6)) {
            comment = "\n" + "\n" + getString(R.string.almost);
        } else if (points == 12) {
            comment = "\n" + "\n" + getString(R.string.great);
        } else {
            comment = getString(R.string.non);
        }
        return comment;
    }
}
