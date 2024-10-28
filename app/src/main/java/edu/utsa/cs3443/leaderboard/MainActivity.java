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
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout playersContainer;
    private EditText usernameEditText;
    private EditText scoreEditText;

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

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlayer();
            }
        });
    }

    private void addPlayer() {
        String username = usernameEditText.getText().toString();
        String score = scoreEditText.getText().toString();

        // Create a new LinearLayout for the player
        LinearLayout playerLayout = new LinearLayout(this);
        playerLayout.setOrientation(LinearLayout.HORIZONTAL);
        playerLayout.setGravity(Gravity.CENTER);
        playerLayout.setPadding(10, 10, 10, 10);

        // Add ImageView
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher_background);
        imageView.setPadding(24, 24, 24, 24);
        playerLayout.addView(imageView);

        // Add TextView
        TextView textView = new TextView(this);
        textView.setText("Player: " + username + ", Score: " + score);
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setPadding(16, 0, 16, 0);
        playerLayout.addView(textView);

        // Add the player layout to the container
        playersContainer.addView(playerLayout);
    }
}