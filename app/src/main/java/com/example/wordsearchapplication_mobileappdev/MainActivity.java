package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button correctButton = findViewById(R.id.correctButton);
        Button wrongButton = findViewById(R.id.wrongButton);
        Button checkPointsButton = findViewById(R.id.checkPointsButton);

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awardPoints(10);
            }
        });

        wrongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deductPoints(10);
            }
        });

        checkPointsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckPointsActivity.class);
                intent.putExtra("points", points);
                startActivity(intent);
            }
        });
    }

    private void awardPoints(int pointsToAdd) {
        points += pointsToAdd;
        displayMessage("That's right! Here is " + pointsToAdd + " stars!");
    }

    private void deductPoints(int pointsToDeduct) {
        points -= pointsToDeduct;
        if (points < 0) {
            points = 0;
        }
        displayMessage("Sorry, that's wrong! -" + pointsToDeduct + " stars");
    }

    private void displayMessage(String message) {
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);
    }
}
