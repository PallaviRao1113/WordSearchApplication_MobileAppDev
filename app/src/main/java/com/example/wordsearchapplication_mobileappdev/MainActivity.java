package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import com.example.wordsearchapplication_mobileappdev.CountDownTimerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimerView timerView;

    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerView = findViewById(R.id.timerView);

        Button easy = findViewById(R.id.easy);
        //Button easyButton = findViewById(R.id.easyButton);
        Button mediumButton = findViewById(R.id.mediumButton);
        Button hardButton = findViewById(R.id.hardButton);

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

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoThirdActivty();
                timerView.startTimer(15 * 60 * 1000); // 15 minutes in milliseconds
            }
        });
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerView.startTimer(10 * 60 * 1000); // 10 minutes in milliseconds
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerView.startTimer(5 * 60 * 1000); // 5 minutes in milliseconds
            }
        });
    }
    public void gotoSecondActivty (View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void gotoThirdActivty ()
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerView.cancelTimer();
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