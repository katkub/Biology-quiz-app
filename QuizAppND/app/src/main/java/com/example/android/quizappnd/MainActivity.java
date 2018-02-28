package com.example.android.quizappnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sending editText value to next activity
        final Button start = findViewById(R.id.startQuiz);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText playerName = findViewById(R.id.edit_name);
                String player = playerName.getText().toString();
                if (TextUtils.isEmpty(player)) {
                    Toast.makeText(MainActivity.this, "Please input your name!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, question1.class);
                    intent.putExtra("name", playerName.getText().toString());
                    Toast.makeText(getApplicationContext(), "Let's start!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }


        });
    }
}
