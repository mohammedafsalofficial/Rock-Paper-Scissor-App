package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView computerChoice, userChoice, result, score;
    Button rockBtn, paperBtn, scissorBtn;
    int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computerChoice = findViewById(R.id.computerChoice);
        userChoice = findViewById(R.id.userChoice);
        result = findViewById(R.id.result);
        score = findViewById(R.id.score);
        rockBtn = findViewById(R.id.rockBtn);
        paperBtn = findViewById(R.id.paperBtn);
        scissorBtn = findViewById(R.id.scissorBtn);


        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice.setText("Rock");
                String computerRandomChoice = randomComputerChoice();
                computerChoice.setText(computerRandomChoice);
                if (computerRandomChoice.equals("Rock")) {
                    result.setText("Draw!");
                } else if (computerRandomChoice.equals("Paper")) {
                    result.setText("You lose!");
                } else if (computerRandomChoice.equals("Scissor")) {
                    result.setText("You win!");
                    score.setText("" + incrementScore());
                    reset(Integer.parseInt(score.getText().toString()));
                }
            }
        });

        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice.setText("Paper");
                String computerRandomChoice = randomComputerChoice();
                computerChoice.setText(computerRandomChoice);
                if (computerRandomChoice.equals("Paper")) {
                    result.setText("Draw!");
                } else if (computerRandomChoice.equals("Scissor")) {
                    result.setText("You lose!");
                } else if (computerRandomChoice.equals("Rock")) {
                    result.setText("You win!");
                    score.setText("" + incrementScore());
                    reset(Integer.parseInt(score.getText().toString()));
                }
            }
        });

        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice.setText("Scissor");
                String computerRandomChoice = randomComputerChoice();
                computerChoice.setText(computerRandomChoice);
                if (computerRandomChoice.equals("Scissor")) {
                    result.setText("Draw!");
                } else if (computerRandomChoice.equals("Rock")) {
                    result.setText("You lose!");
                } else if (computerRandomChoice.equals("Paper")) {
                    result.setText("You win!");
                    score.setText("" + incrementScore());
                    reset(Integer.parseInt(score.getText().toString()));
                }
            }
        });
    }

    public int incrementScore() {
        return ++finalScore;
    }

    public void reset(int score) {
        if (score == 10) {
            finalScore = 0;
        }
    }

    public String randomComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0 -> { return "Rock"; }
            case 1 -> { return "Paper"; }
            default -> { return "Scissor"; }
        }
    }
}
