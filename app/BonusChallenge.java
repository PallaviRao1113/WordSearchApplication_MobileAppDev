import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BonusChallenge extends AppCompatActivity {

    private TextView messageTextView;
    private Button startBonusRoundButton;

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
        // In a real app, you would have logic to generate a word search puzzle
        // and determine a target word for the bonus round.

        String targetWord = "BONUS"; // Example target word

        // Display instructions to the user
        messageTextView.setText("Bonus Round: Find the word '" + targetWord + "'!");

        // In a real app, you would have a word search puzzle displayed, and the user
        // interacts with it to find the target word.

        // For simplicity, let's assume the user finds the word successfully.
        // In a real app, you would have logic to check if the user found the word.

        // Assuming the user found the word successfully
        int starsEarned = 20;
        displaySuccessMessage(starsEarned);
    }

    private void displaySuccessMessage(int starsEarned) {
        // Display a success message to the user
        messageTextView.setText("Congratulations! You found the word and earned " +
                starsEarned + " stars!");


    }
}



