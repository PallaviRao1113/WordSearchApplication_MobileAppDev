package com.example.wordsearchapplication_mobileappdev;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckPointsActivity extends AppCompatActivity {
    private int points;// Declare points at the class level
    public static int totalpoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_points);

        Intent intent = getIntent();
        points = intent.getIntExtra("points", 0);

        SharedPreferences sharedPreferences = getSharedPreferences("appPoints", Context.MODE_PRIVATE);
        points = sharedPreferences.getInt("points", 0);

        totalpoints = points ;


        TextView pointsTextView = findViewById(R.id.pointsTextView);
        pointsTextView.setText("You have " + points + " stars");

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMainActivity();
            }
        });
    }

    private int getPointsFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("appPoints", Context.MODE_PRIVATE);
        // Retrieve points globally for the app, defaulting to 0 if not found
        return sharedPreferences.getInt("points", 0);
    }

    private void savePointsToSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("appPoints", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Save points globally for the app
        editor.putInt("points", points);
        editor.apply();
    }

    public void gotoSecondActivity(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void gotoThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void gotoMainActivity() {
        // Save the updated points to SharedPreferences before navigating to MainActivity

        savePointsToSharedPreferences();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void awardPoints(int pointsToAdd) {
        points += pointsToAdd;
        displayMessage("That's right! Here is " + pointsToAdd + " stars!");

        // Save the updated points to SharedPreferences
        savePointsToSharedPreferences();
    }

    private void deductPoints(int pointsToDeduct) {
        points -= pointsToDeduct;
        if (points < 0) {
            points = 0;
        }
        displayMessage("Sorry, that's wrong! -" + pointsToDeduct + " stars");

        // Save the updated points to SharedPreferences
        savePointsToSharedPreferences();
    }
    private void displayMessage(String message) {
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);
    }

}
