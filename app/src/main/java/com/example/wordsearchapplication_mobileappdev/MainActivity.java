package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        Button medium = findViewById(R.id.medium);
        Button hard = findViewById(R.id.button);
        Button bonusButton = findViewById(R.id.bonusButton);

        Button checkPointsButton = findViewById(R.id.checkPointsButton);

        checkPointsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCheckPointsActivity();

            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoThirdActivty();
                timerView.startTimer(3 * 60 * 1000); // 15 minutes in milliseconds
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFourthActivity();
                timerView.startTimer(2 * 60 * 1000); // 10 minutes in milliseconds
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFifthActivity();
                timerView.startTimer(1 * 60 * 1000); // 5 minutes in milliseconds
            }
        });


        bonusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSixthActivity();
                timerView.startTimer(1 * 60 * 1000); // 5 minutes in milliseconds
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

    public void gotoCheckPointsActivity(){
        Intent intent = new Intent(this, CheckPointsActivity.class);
        intent.putExtra("points", points);
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

        // Save the updated points to SharedPreferences
        savePointsToSharedPreferences(points);
    }

    private void deductPoints(int pointsToDeduct) {
        points -= pointsToDeduct;
        if (points < 0) {
            points = 0;
        }
        displayMessage("Sorry, that's wrong! -" + pointsToDeduct + " stars");

        // Save the updated points to SharedPreferences
        savePointsToSharedPreferences(points);
    }

    private void savePointsToSharedPreferences(int points) {
        SharedPreferences sharedPreferences = getSharedPreferences("appPoints", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Save points globally for the app
        editor.putInt("totalPoints", points);
        editor.apply();
    }


    private void displayMessage(String message) {
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);
    }

    public void gotoSecondActivity (View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void gotoSixthActivity ()
    {
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }

    public void gotoThirdActivity (View v)
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void gotoFourthActivity ()
    {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }



    public void gotoFifthActivity ()
    {
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }
    public void gotoErrorScreen ()
    {
        Intent intent = new Intent(this, Error_Screen.class);
        startActivity(intent);
    }
}