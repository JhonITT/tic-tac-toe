package com.example.altice.tictactoe.controllers;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.altice.tictactoe.models.Board;
import com.example.altice.tictactoe.models.Mode;
import com.example.altice.tictactoe.models.Player;
import com.example.altice.tictactoe.models.User;

/**
 * Created by JmFernandezA on 09/03/2018.
 */

public class TicTacToeController {
    
    private TextView tvPosition00;
    private TextView tvPosition01;
    private TextView tvPosition02;
    private TextView tvPosition10;
    private TextView tvPosition11;
    private TextView tvPosition12;
    private TextView tvPosition20;
    private TextView tvPosition21;
    private TextView tvPosition22;
    private TextView tvTurn;
    private TextView tvPlayerOne;
    private TextView tvDraw;
    private TextView tvPlayerTwo;
    private Board board;
    private Context context;
    private int countP1;
    private int countP2;
    private int countDraw;
    private User playerOne;
    private User playerTwo;
    private Mode mode;

    public TicTacToeController(
            Context context,
            Board board,
            TextView tvPosition00, TextView tvPosition01, TextView tvPosition02,
            TextView tvPosition10, TextView tvPosition11, TextView tvPosition12,
            TextView tvPosition20, TextView tvPosition21, TextView tvPosition22,
            TextView tvTurn,TextView tvPlayerOne,TextView tvDraw,TextView tvPlayerTwo,
            Mode mode)
    {
        this.mode = mode;
        this.board = board;
        this.context = context;
        this.tvPosition00 = tvPosition00;
        this.tvPosition01 = tvPosition01;
        this.tvPosition02 = tvPosition02;
        this.tvPosition10 = tvPosition10;
        this.tvPosition11 = tvPosition11;
        this.tvPosition12 = tvPosition12;
        this.tvPosition20 = tvPosition20;
        this.tvPosition21 = tvPosition21;
        this.tvPosition22 = tvPosition22;
        this.tvTurn = tvTurn;
        this.tvPlayerOne = tvPlayerOne;
        this.tvDraw = tvDraw;
        this.tvPlayerTwo = tvPlayerTwo;

        this.playerOne = new User("Jhon","123456789",Player.X);
        this.playerTwo = new User("Marlon","123456789",Player.O);
        this.countP1 = 0;
        this.countP2 = 0;
        this.countDraw = 0;
        
        this.tvTurn.setText(findPlayerByTurn(board.getTurn()));

    }

    public String findPlayerByTurn(Player turn){
        if (playerOne.player.equals(turn)){
            return "P1";
        }else{
            return "P2";
        }
    }




    public void jugar(int fila, int colunna) {

        //---------Jugada-----------------------
        if (board.nextMove(fila, colunna) != null) {

            board = board.nextMove(fila, colunna);
            pintarTablero(board);

            if (board.isDraw()) {
                Toast.makeText(context,"Es un empate",Toast.LENGTH_LONG).show();
                board.beginAgain();
                pintarTablero(board);
            } else if (board.getWeight(Player.X) == 2) {
                Toast.makeText(context,"X: Gano",Toast.LENGTH_LONG).show();
                board.beginAgain();
                pintarTablero(board);
            } else if (board.getWeight(Player.O) == 2) {
                Toast.makeText(context,"O: Gano",Toast.LENGTH_LONG).show();
                board.beginAgain();
                pintarTablero(board);
            }


            this.tvTurn.setText(findPlayerByTurn(board.getTurn()));
        } else {
            return;
        }

        if (mode.equals(Mode.OnePlayer)){

            //--------------------------------------
            if (board.getMoveds()== 0) {
                double valor = Math.random() * 100;
                if (valor <= 20) {
                    board = board.nextMove(0, 0);
                } else if (valor > 20 && valor <= 40) {
                    board = board.nextMove(0, 2);
                } else if (valor > 40 && valor <= 60) {
                    board = board.nextMove(2, 0);
                } else if (valor > 60 && valor <= 80) {
                    board = board.nextMove(2, 2);
                } else if (valor > 80 && valor <= 100) {
                    board = board.nextMove(1, 1);
                }
                pintarTablero(board);
            } else if (board.getMoveds()== 1) {
                if (board.nextMove(1, 1) != null) {
                    board = board.nextMove(1, 1);
                    pintarTablero(board);
                } else {
                    double valor = Math.random() * 100;
                    if (valor <= 25) {
                        board = board.nextMove(0, 0);
                    } else if (valor > 25 && valor <= 50) {
                        board = board.nextMove(0, 2);
                    } else if (valor > 50 && valor <= 75) {
                        board = board.nextMove(2, 0);
                    } else if (valor > 75 && valor <= 100) {
                        board = board.nextMove(2, 2);
                    }

                    pintarTablero(board);
                }

            } else if (board.nextForcedMovements().size() > 0) {

                if (board.nextForcedMovements().size() > 1) {
                    if (board.nextForcedMovements().get(0).getWeight(board.getTurn()) > board.nextForcedMovements().get(1).getWeight(board.getTurn())) {
                        board = board.nextForcedMovements().get(0);
                    } else {
                        board = board.nextForcedMovements().get(1);
                    }
                }else{
                    board = board.nextForcedMovements().get(0);
                }

                //board = board.proximasJugadasForzadas().get(0);
                pintarTablero(board);

                if (board.isDraw()) {
                    Toast.makeText(context,"tablas",Toast.LENGTH_LONG).show();
                    board.beginAgain();
                    pintarTablero(board);
                } else if (board.getWeight(Player.X) == 2) {
                    Toast.makeText(context,"X: Gano",Toast.LENGTH_LONG).show();
                    board.beginAgain();
                    pintarTablero(board);
                } else if (board.getWeight(Player.O) == 2) {
                    Toast.makeText(context,"O: Gano",Toast.LENGTH_LONG).show();
                    board.beginAgain();
                    pintarTablero(board);
                }
            } else {

                int max = 0;
                Board mejorCamino = board.nextMovements().get(0);

                for (Board proximaJugada : board.nextMovements()) {
                    for (Board camino : proximaJugada.nextForcedMovements()) {
                        if (camino.roadWeight(camino) > max) {
                            mejorCamino = proximaJugada;
                            max = camino.roadWeight(camino);
                        }
                    }
                }

                board = mejorCamino;
                pintarTablero(board);

                if (board.isDraw()) {
                    Toast.makeText(context,"tablas",Toast.LENGTH_LONG).show();
                    board.beginAgain();
                    pintarTablero(board);
                } else if (board.getWeight(Player.X) == 2) {
                    Toast.makeText(context,"X: Gano",Toast.LENGTH_LONG).show();
                    board.beginAgain();
                    pintarTablero(board);
                } else if (board.getWeight(Player.O) == 2) {
                    Toast.makeText(context,"O: Gano",Toast.LENGTH_LONG).show();
                    board.beginAgain();
                    pintarTablero(board);
                }
            }

        }

    }

    public void pintarTablero(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pintarCasilla(i, j, board.getBoard()[i][j]);
            }
        }
    }

    public void pintarCasilla(int fila, int colunna, Player marca) {
        switch (fila) {
            case 0:
                switch (colunna) {
                    case 0:
                        tvPosition00.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;
                    case 1:
                        tvPosition01.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;
                    case 2:
                        tvPosition02.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;

                }
                break;
            case 1:
                switch (colunna) {
                    case 0:
                        tvPosition10.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;
                    case 1:
                        tvPosition11.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;
                    case 2:
                        tvPosition12.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;

                }
                break;
            case 2:
                switch (colunna) {
                    case 0:
                        tvPosition20.setText(marca.equals(Player.NULL)?"":(marca.equals(Player.X)?"X":"O"));
                        break;
                    case 1:
                        tvPosition21.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;
                    case 2:
                        tvPosition22.setText(marca.equals(Player.NULL)?"":( marca.equals(Player.X)?"X":"O"));
                        break;

                }
                break;

        }
    }
}
