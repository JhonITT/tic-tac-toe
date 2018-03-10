package com.example.altice.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.altice.tictactoe.controllers.Repository;
import com.example.altice.tictactoe.models.Mode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOnePlayer).setOnClickListener( v -> {
            Repository.instance.mode = Mode.OnePlayer;
            startActivity(new Intent(this, TicTacToeActivity.class));
        });

        findViewById(R.id.btnTwoPlayers).setOnClickListener( v -> {
            Repository.instance.mode = Mode.TwoPlayer;
            startActivity(new Intent(MainActivity.this, TicTacToeActivity.class));
        });

        findViewById(R.id.btnSeeYourScore).setOnClickListener( v -> {
            startActivity(new Intent(MainActivity.this, ScoreActivity.class));
        });


    }
}
