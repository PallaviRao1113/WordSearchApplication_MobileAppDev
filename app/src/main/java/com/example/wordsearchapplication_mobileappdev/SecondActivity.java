package com.example.wordsearchapplication_mobileappdev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button soundtrackOne;
    private Button soundtrackTwo;
    private Button soundtrackThree;
    private Button turnMusicOff;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        soundtrackOne = findViewById(R.id.soundtrackOne);
        soundtrackTwo = findViewById(R.id.soundtrackTwo);
        soundtrackThree = findViewById(R.id.soundtrackThree);
        turnMusicOff = findViewById(R.id.turnMusicOff);
        mediaPlayer = new MediaPlayer();

        soundtrackOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSoundtrack(R.raw.one);
            }
        });

        soundtrackTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSoundtrack(R.raw.two);
            }
        });

        soundtrackThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSoundtrack(R.raw.three);
            }
        });

        turnMusicOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();
                }
            }
        });
    }

    private void playSoundtrack(int soundtrackResource) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundtrackResource);
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer newMedia)
            {
                newMedia.seekTo(0);
                newMedia.start();
            }
        });
        mediaPlayer.start();
    }

    public void gotoMainActivity (View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}