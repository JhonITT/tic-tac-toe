package com.example.altice.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOnePlayer).setOnClickListener( v -> startActivity(new Intent(this, LevelActivity.class)));
        findViewById(R.id.btnTwoPlayers).setOnClickListener( v -> startActivity(new Intent(this, MainActivity.class)));
        findViewById(R.id.btnPlayOnline).setOnClickListener( v -> startActivity(new Intent(this, MainActivity.class)));

    }
}
