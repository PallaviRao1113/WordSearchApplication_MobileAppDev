package com.example.wordsearchapplication_mobileappdev;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;
    private Button startBonusRoundButton;

    private static final int BONUS_ROUND_DURATION = 15000; // 15 seconds
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_challenge);

        messageTextView = findViewById(R.id.messageTextView);
        startBonusRoundButton = findViewById(R.id.startBonusRoundButton);

        startBonusRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBonusRound();
            }
        });
    }

    private void startBonusRound() {
        // Generate a random target word for the bonus round
        String targetWord = generateRandomWord();

        // Display instructions to the user
        messageTextView.setText("Bonus Challenge: Find the word '" + targetWord + "'!");

        // Delay for 15 seconds and then display success or failure messages
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Assuming the user found the word successfully
                int starsEarned = 20;
                displayResultMessage(true, starsEarned);
            }
        }, BONUS_ROUND_DURATION);
    }

    private void displayResultMessage(boolean success, int starsEarned) {
        if (success) {
            // Display a success message to the user
            messageTextView.setText("That's Right! Here are " + starsEarned + " stars!");
        } else {
            // Display a failure message to the user
            messageTextView.setText("Sorry, Try again!");
        }
    }

    private String generateRandomWord() {
        // For simplicity, using a predefined list of words
        String[] words = {"BONUS", "SEARCH", "CHALLENGE", "ANDROID", "DEVELOPMENT"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove any pending callbacks
        handler.removeCallbacksAndMessages(null);
    }
}
