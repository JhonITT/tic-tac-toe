package com.example.altice.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.altice.tictactoe.controllers.Repository;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView tvScore = findViewById(R.id.tvScore);
        TextView tvWin = findViewById(R.id.tvWin);
        TextView tvDraw = findViewById(R.id.tvDraw);
        TextView tvLose = findViewById(R.id.tvLose);
        ListView lsHistory = findViewById(R.id.lvHistory);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Repository.instance.histories());

        lsHistory.setAdapter(itemsAdapter);

        tvScore.setText(Integer.toString(Repository.instance.getScore()));
        tvWin.setText(Integer.toString(Repository.instance.getWins()));
        tvDraw.setText(Integer.toString(Repository.instance.getDraws()));
        tvLose.setText(Integer.toString(Repository.instance.getLoses()));

    }
}
