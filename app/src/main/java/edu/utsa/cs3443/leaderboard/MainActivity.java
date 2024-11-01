package edu.utsa.cs3443.leaderboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import edu.utsa.cs3443.leaderboard.model.LeaderBoard;
import edu.utsa.cs3443.leaderboard.model.Player;

public class MainActivity extends AppCompatActivity {

    private LinearLayout playersContainer;
    private EditText usernameEditText;
    private EditText scoreEditText;
    private ScrollView scrollView;
    private LeaderBoard leaderBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        playersContainer = findViewById(R.id.players_container);
        usernameEditText = findViewById(R.id.txt_name);
        scoreEditText = findViewById(R.id.txt_score);
        Button addButton = findViewById(R.id.btn_add);
        Button showButton = findViewById(R.id.btn_show);
        scrollView = findViewById(R.id.scroll_view);

        loadLeaderBoard();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlayer();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dynamicLoad(leaderBoard.getPlayers());
            }
        });
    }

    private void addPlayer() {
        String username = usernameEditText.getText().toString().trim();
        String scoreInput = scoreEditText.getText().toString().trim()   ;

        // Validate score input
        int score;
        try {
            score = Integer.parseInt(scoreInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number for score.", Toast.LENGTH_SHORT).show();
            return;
        }

        leaderBoard.addPlayer(new Player(username,score));
        leaderBoard.savePlayer();
        dynamicLoad(leaderBoard.getPlayers());
    }

    private void dynamicLoad(ArrayList<Player> players){
        if (players == null){
            return;
        }

        playersContainer.removeAllViews();

        for (Player player : players){
            // Create a new LinearLayout for the player
            LinearLayout playerLayout = new LinearLayout(this);
            playerLayout.setOrientation(LinearLayout.HORIZONTAL);
            playerLayout.setGravity(Gravity.CENTER_VERTICAL);
            playerLayout.setPadding(10, 10, 10, 10);

            // Add ImageView
            ImageView imageView = new ImageView(this);
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            imageView.setPadding(24, 24, 24, 24);
            // Set margins for the ImageView
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            imageParams.setMargins(100, 0, 0, 0); // Left, top, right, bottom margins
            imageView.setLayoutParams(imageParams);

            // Use Glide to load the image from URL
            Glide.with(this)
                    .load(player.getImgUrl()) // Load image URL from player object
                    .into(imageView);

            playerLayout.addView(imageView);

            // Add TextView
            TextView textView = new TextView(this);
            textView.setText("Player: " + player.getName() + ", Score: " + player.getScore());
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setPadding(16, 0, 16, 0);
            playerLayout.addView(textView);

            // Add the player layout to the container
            playersContainer.addView(playerLayout);


            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            });
        }
    }

    private void loadLeaderBoard(){
        leaderBoard = new LeaderBoard();
        leaderBoard.loadPlayer();
    }
}