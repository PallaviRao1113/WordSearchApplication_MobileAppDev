package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;
import com.example.wordsearchapplication_mobileappdev.CountDownTimerView;

public class ThirdActivity extends AppCompatActivity {
    private static final int GRID_SIZE = 3;
    private StringBuilder selectedLetters = new StringBuilder();
    private GridLayout gridLayout;
    public CountDownTimerView timerr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        gridLayout = findViewById(R.id.gridLayout);
        generateAndDisplayLayout();
        timerr = findViewById(R.id.timerr);
        timerr.startTimer(15 * 60 * 1000);
    }
    private void generateAndDisplayLayout() {
        String[] words = {"cat", "dog", "cow", "sun", "job", "dad", "mom", "kid", "car", "rug", "boy", "two", "day"};
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
                Toast.makeText(ThirdActivity.this, "Button Clicked: " + buttonText, Toast.LENGTH_SHORT).show();
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

        if (selectedLetters.length() == 3) {
            String selectedWord = selectedLetters.toString().toLowerCase();
            Log.d("WordCheck", "Selected Word: " + selectedWord);

            if (isWord(selectedWord)) {
                Log.d("WordCheck", "Valid Word! Navigating to MainActivity");
                // Word is valid, navigate to the desired activity
                // CHANGE THIS TO GO TO POINT SYSTEM RIGHT SCReEN
                gotoMainActivity();
            } else {
                Log.d("WordCheck", "Not a valid word");
                // CHANGE THIS TO GO TO POINT SYSTEM WRONG SCReEN
                //gotoMainActivity();
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

    public void gotoMainActivity ()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void gotoSecondActivity (View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
