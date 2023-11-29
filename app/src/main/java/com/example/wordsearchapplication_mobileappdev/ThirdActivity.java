package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = findViewById(R.id.textView);
        generateAndDisplayLayout();
    }
    private char getRandomEnglishLetter() {
        int randomChar = (int) (Math.random() * 26) + 'a';
        return (char) randomChar;
    }
    private String getRandomEnglishWord() {
        String[] words = {"apple", "candy", "brown", "grape", "straw", "berry", "truck", "plane", "panda", "tiger", "horse", "award", "enjoy", "enter", "grass", "funny", "metal"};
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
    private void generateAndDisplayLayout() {
        char[][] layout = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                layout[i][j] = getRandomEnglishLetter();
            }
        }
        int randomRow = (int) (Math.random() * 5);
        String randomWord = getRandomEnglishWord();
        for (int i = 0; i < 5; i++) {
            layout[randomRow][i] = randomWord.charAt(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                stringBuilder.append(layout[i][j]);
            }
            stringBuilder.append("\n");
        }
        textView.setText(stringBuilder.toString());
    }
    public void gotoMainActivty (View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}