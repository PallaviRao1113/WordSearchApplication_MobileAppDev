package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import com.example.wordsearchapplication_mobileappdev.CountDownTimerView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimerView timerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerView = findViewById(R.id.timerView);

        Button easy = findViewById(R.id.easy);
        //Button easyButton = findViewById(R.id.easyButton);
        Button mediumButton = findViewById(R.id.mediumButton);
        Button hardButton = findViewById(R.id.hardButton);

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

}