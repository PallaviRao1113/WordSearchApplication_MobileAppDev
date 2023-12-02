package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class FifthActivity extends AppCompatActivity {
    private static final int GRID_SIZE = 7;
    private StringBuilder selectedLetters = new StringBuilder();
    public CountDownTimerView timerr;

    private GridLayout gridLayout;
    private int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        gridLayout = findViewById(R.id.gridLayout);
        generateAndDisplayLayout();
        timerr = findViewById(R.id.timerr);
        timerr.startTimer(5 * 60 * 1000);
    }
    private void generateAndDisplayLayout() {
        String[] words = {"ladybug", "natural", "science", "vitamin", "victory", "weather", "teacher", "fiction", "fifteen", "imagine"};
        int randomRow = (int) (Math.random() * GRID_SIZE);
        for (int i = 0; i < GRID_SIZE; i++) {
            char[] rowContent;
            if (i == randomRow) {
                String selectedWord = words[new Random().nextInt(words.length)];
                rowContent = selectedWord.toCharArray();
            } else {
                rowContent = new char[GRID_SIZE];
                for (int j = 0; j < GRID_SIZE; j++) {
                    rowContent[j] = getRandomEnglishLetter();
                }
            }
            for (int j = 0; j < GRID_SIZE; j++) {
                addButtonToGrid(Character.toString(rowContent[j]));
            }
        }
    }

    private char getRandomEnglishLetter() {
        int randomChar = (int) (Math.random() * 26) + 'a';
        return (char) randomChar;
    }

    private void addButtonToGrid(String buttonText) {
        Button button = new Button(this);
        button.setText(buttonText);
        button.setTextSize(18);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FifthActivity.this, "Button Clicked: " + buttonText, Toast.LENGTH_SHORT).show();
                handleLetterButtonClick(buttonText);
            }
        });
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        button.setLayoutParams(params);
        gridLayout.addView(button);
    }
    private void handleLetterButtonClick(String letter) {
        selectedLetters.append(letter);

        // Log the clicked letter
        Log.d("ButtonClicked", "Clicked Letter: " + letter);

        if (selectedLetters.length() == 7) {
            String selectedWord = selectedLetters.toString().toLowerCase();
            Log.d("WordCheck", "Selected Word: " + selectedWord);

            if (isWord(selectedWord)) {
                Log.d("WordCheck", "Valid Word! Navigating to MainActivity");
                // Word is valid, navigate to the desired activity
                // CHANGE THIS TO GO TO POINT SYSTEM RIGHT SCReEN
                gotoCheckPointsActivity();
                awardPoints(1);

            } else {
                Log.d("WordCheck", "Not a valid word");
                // CHANGE THIS TO GO TO POINT SYSTEM WRONG SCReEN
                gotoCheckPointsActivity();
                deductPoints(1);
            }

            // Clear selected letters for the next word
            selectedLetters.setLength(0);
        }
    }

    private boolean isWord(String selectedWord) {
        // Implement your logic to check if the selected word is valid
        // For simplicity, let's check against a predefined list of words
        String[] validWords = {"cat", "dog", "cow", "sun", "job", "dad", "mom", "kid", "car", "rug", "boy", "two", "day"};
        return Arrays.asList(validWords).contains(selectedWord);
    }

    public void gotoMainActivity (View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void gotoSecondActivity (View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void gotoCheckPointsActivity(){
        Intent intent = new Intent(this, CheckPointsActivity.class);
        intent.putExtra("points", points);
        startActivity(intent);
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
