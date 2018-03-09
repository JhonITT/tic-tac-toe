package com.example.altice.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.altice.tictactoe.controllers.TicTacToeController;
import com.example.altice.tictactoe.models.Board;
import com.example.altice.tictactoe.models.Mode;

public class TicTacToeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        TextView tvPosition00 = findViewById(R.id.tvPosition00);
        TextView tvPosition01 = findViewById(R.id.tvPosition01);
        TextView tvPosition02 = findViewById(R.id.tvPosition02);
        TextView tvPosition10 = findViewById(R.id.tvPosition10);
        TextView tvPosition11 = findViewById(R.id.tvPosition11);
        TextView tvPosition12 = findViewById(R.id.tvPosition12);
        TextView tvPosition20 = findViewById(R.id.tvPosition20);
        TextView tvPosition21 = findViewById(R.id.tvPosition21);
        TextView tvPosition22 = findViewById(R.id.tvPosition22);
        TextView tvTurn = findViewById(R.id.tvTurn);
        TextView tvPlayerOne = findViewById(R.id.tvPlayerOne);
        TextView tvDraw = findViewById(R.id.tvDraw);
        TextView tvPlayerTwo = findViewById(R.id.tvPlayerTwo);



        Board estadoActual = new Board();

        TicTacToeController controlador = new TicTacToeController(
                this,
                estadoActual,
                tvPosition00,tvPosition01,tvPosition02,
                tvPosition10,tvPosition11,tvPosition12,
                tvPosition20, tvPosition21, tvPosition22,
                tvTurn,tvPlayerOne,tvDraw,tvPlayerTwo,
                Mode.OnePlayer
        );

        tvPosition00.setOnClickListener(v -> controlador.jugar(0,0));
        tvPosition01.setOnClickListener(v -> controlador.jugar(0,1));
        tvPosition02.setOnClickListener(v -> controlador.jugar(0,2));
        tvPosition10.setOnClickListener(v -> controlador.jugar(1,0));
        tvPosition11.setOnClickListener(v -> controlador.jugar(1,1));
        tvPosition12.setOnClickListener(v -> controlador.jugar(1,2));
        tvPosition20.setOnClickListener(v -> controlador.jugar(2,0));
        tvPosition21.setOnClickListener(v -> controlador.jugar(2,1));
        tvPosition22.setOnClickListener(v -> controlador.jugar(2,2));



    }
}
