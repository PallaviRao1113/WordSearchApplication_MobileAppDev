package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;
import java.util.Random;
import com.example.wordsearchapplication_mobileappdev.CountDownTimerView;

public class ThirdActivity extends AppCompatActivity {
    private static final int GRID_SIZE = 3;
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
            }
        });
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        button.setLayoutParams(params);
        gridLayout.addView(button);
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
}
