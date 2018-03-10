package com.example.altice.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JmFernandezA on 09/03/2018.
 */

public class Board {


    private Player turn;
    private Player[][] board;
    private int moveCounter;

    public Board() {
        turn = Player.X;
        board = new Player[][]{{Player.NULL, Player.NULL, Player.NULL}, {Player.NULL, Player.NULL, Player.NULL}, {Player.NULL, Player.NULL, Player.NULL}};
    }

    public Board(Player turn, Player[][] board, int moveCounter) {
        this.turn = turn;
        this.moveCounter = moveCounter;
        this.board = new Player[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public Board nextMove(int row, int column) {
        if (board[row][column].equals(Player.NULL)) {
            if (turn == Player.X) {
                Board nextMoveBoard = new Board(Player.O, board, moveCounter + 1);
                nextMoveBoard.getBoard()[row][column] = Player.X;
                return nextMoveBoard;
            } else {
                Board nextMoveBoard = new Board(Player.X, board, moveCounter + 1);
                nextMoveBoard.getBoard()[row][column] = Player.O;
                return nextMoveBoard;
            }
        }
        return null;
    }

    public List<Board> nextMovements() {
        List<Board> nextMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nextMove(i, j) != null) {
                    nextMoves.add(nextMove(i, j));
                }
            }
        }
        if (nextMoves.isEmpty()) {
            return null;
        }
        return nextMoves;
    }

    public void checkRows(List<Board> nextForcedMovements) {

        //Verificar Filas
        for (int i = 0; i < 3; i++) {

            //verificar X
            if (board[i][0].equals(Player.NULL) && board[i][1].equals(Player.X) && board[i][2].equals(Player.X)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(i, 0);
                nextForcedMovements.add(nextForceMove);
            } else if (board[i][0].equals(Player.X) && board[i][1].equals(Player.NULL) && board[i][2].equals(Player.X)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(i, 1);
                nextForcedMovements.add(nextForceMove);
            } else if (board[i][0].equals(Player.X) && board[i][1].equals(Player.X) && board[i][2].equals(Player.NULL)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(i, 2);
                nextForcedMovements.add(nextForceMove);
            }

            //verificar O
            if (board[i][0].equals(Player.NULL) && board[i][1].equals(Player.O) && board[i][2].equals(Player.O)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(i, 0);
                nextForcedMovements.add(nextForceMove);
            } else if (board[i][0].equals(Player.O) && board[i][1].equals(Player.NULL) && board[i][2].equals(Player.O)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(i, 1);
                nextForcedMovements.add(nextForceMove);
            } else if (board[i][0].equals(Player.O) && board[i][1].equals(Player.O) && board[i][2].equals(Player.NULL)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(i, 2);
                nextForcedMovements.add(nextForceMove);
            }
        }

    }

    public void checkColumns(List<Board> nextForcedMovements) {

        //verificar Colunnas
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(Player.NULL) && board[1][i].equals(Player.X) && board[2][i].equals(Player.X)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(0, i);
                nextForcedMovements.add(nextForceMove);
            } else if (board[0][i].equals(Player.X) && board[1][i].equals(Player.NULL) && board[2][i].equals(Player.X)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(1, i);
                nextForcedMovements.add(nextForceMove);
            } else if (board[0][i].equals(Player.X) && board[1][i].equals(Player.X) && board[2][i].equals(Player.NULL)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(2, i);
                nextForcedMovements.add(nextForceMove);
            }

            if (board[0][i].equals(Player.NULL) && board[1][i].equals(Player.O) && board[2][i].equals(Player.O)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(0, i);
                nextForcedMovements.add(nextForceMove);
            } else if (board[0][i].equals(Player.O) && board[1][i].equals(Player.NULL) && board[2][i].equals(Player.O)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(1, i);
                nextForcedMovements.add(nextForceMove);
            } else if (board[0][i].equals(Player.O) && board[1][i].equals(Player.O) && board[2][i].equals(Player.NULL)) {
                Board nextForceMove = new Board(turn, board, moveCounter);
                nextForceMove = nextForceMove.nextMove(2, i);
                nextForcedMovements.add(nextForceMove);
            }

        }

    }

    public void checkDiagonal(List<Board> nextForcedMovements) {

        // Verificar Diagonales
        if (board[0][0].equals(Player.NULL) && board[1][1].equals(Player.X) && board[2][2].equals(Player.X)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(0, 0);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][0].equals(Player.X) && board[1][1].equals(Player.NULL) && board[2][2].equals(Player.X)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(1, 1);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][0].equals(Player.X) && board[1][1].equals(Player.X) && board[2][2].equals(Player.NULL)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(2, 2);
            nextForcedMovements.add(nextForceMove);
        }

        if (board[0][0].equals(Player.NULL) && board[1][1].equals(Player.O) && board[2][2].equals(Player.O)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(0, 0);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][0].equals(Player.O) && board[1][1].equals(Player.NULL) && board[2][2].equals(Player.O)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(1, 1);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][0].equals(Player.O) && board[1][1].equals(Player.O) && board[2][2].equals(Player.NULL)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(2, 2);
            nextForcedMovements.add(nextForceMove);
        }

        if (board[0][2].equals(Player.NULL) && board[1][1].equals(Player.X) && board[2][0].equals(Player.X)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(0, 2);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][2].equals(Player.X) && board[1][1].equals(Player.NULL) && board[2][0].equals(Player.X)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(1, 1);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][2].equals(Player.X) && board[1][1].equals(Player.X) && board[2][0].equals(Player.NULL)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(2, 0);
            nextForcedMovements.add(nextForceMove);
        }

        if (board[0][2].equals(Player.NULL) && board[1][1].equals(Player.O) && board[2][0].equals(Player.O)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(0, 2);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][2].equals(Player.O) && board[1][1].equals(Player.NULL) && board[2][0].equals(Player.O)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(1, 1);
            nextForcedMovements.add(nextForceMove);
        } else if (board[0][2].equals(Player.O) && board[1][1].equals(Player.O) && board[2][0].equals(Player.NULL)) {
            Board nextForceMove = new Board(turn, board, moveCounter);
            nextForceMove = nextForceMove.nextMove(2, 0);
            nextForcedMovements.add(nextForceMove);
        }

    }

    public List<Board> nextForcedMovements() {
        List<Board> nextForcedMovements = new ArrayList<>();

        checkRows(nextForcedMovements);
        checkColumns(nextForcedMovements);
        checkDiagonal(nextForcedMovements);

        return nextForcedMovements;

    }

    public int roadWeight(Board roadToGo){
        int valor =1;
        List<Board> forcedMovements = roadToGo.nextForcedMovements();
        if (forcedMovements!=null) {
            for (Board forcedMove : forcedMovements) {
                valor*=roadWeight(forcedMove);
            }
        }else {
            List<Board> nextMovements = roadToGo.nextMovements();
            if (nextMovements != null) {
                for (Board nextMove : nextMovements) {
                    valor*=roadWeight(nextMove);
                }

            }
        }
        return valor*roadToGo.getWeight(turn);
    }

    public int getWeight(Player player) {

        for (int i = 0; i < 3; i++) {
            byte count = 0;
            for (int j = 0; j < 3; j++) {
                count += (board[i][j].equals(player)) ? 1 : 0;
            }
            if (count == 3) {
                return 2;
            }
        }

        for (int j = 0; j < 3; j++) {
            byte count = 0;
            for (int i = 0; i < 3; i++) {
                count += (board[i][j].equals(player)) ? 1 : 0;
            }
            if (count == 3) {
                return 2;
            }
        }

        //diagonales
        if (board[0][0].equals(player) &&  board[1][1].equals(player) &&  board[2][2].equals(player)) {
            return 2;
        }

        if (board[0][2].equals(player) &&  board[1][1].equals(player) &&  board[2][0].equals(player)) {
            return 2;
        }

        //-------------------------------------------------------------------
        for (int i = 0; i < 3; i++) {
            byte count = 0;
            for (int j = 0; j < 3; j++) {
                count += (board[i][j].equals(getOppositeTurn())) ? 1 : 0;
            }
            if (count == 3) {
                return 0;
            }
        }
        //busqueda de ganador por columnas
        for (int j = 0; j < 3; j++) {
            byte count = 0;
            for (int i = 0; i < 3; i++) {
                count += (board[i][j].equals(getOppositeTurn())) ? 1 : 0;
            }
            if (count == 3) {
                return 0;
            }
        }
        //diagonales
        if (board[0][0].equals(getOppositeTurn()) && board[1][1].equals(getOppositeTurn()) && board[2][2].equals(getOppositeTurn())) {
            return 0;
        }

        if (board[0][2].equals(getOppositeTurn()) && board[1][1].equals(getOppositeTurn()) && board[2][0].equals(getOppositeTurn())) {
            return 0;
        }

        return 1;
    }

    public State getState(){
        if (isDraw()) {
            return State.DRAW;
        }else if (getWeight(Player.X) == 2){
            return State.WIN_X;
        }else if (getWeight(Player.O) == 2){
            return State.WIN_O;
        }else{
            return State.UNDEFINED;
        }
    }

    public boolean isDraw(){
        for ( int i = 0 ; i < 3 ; i++ ){
            for ( int j = 0 ; j < 3 ; j++){
                if(board[i][j] == Player.NULL)
                    return false;
            }
        }
        return true;
    }

    public void beginAgain() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Player.NULL;
            }
        }

        turn = (turn.equals(Player.X)) ? Player.O : Player.X;
        moveCounter = 0;
    }

    public Player getOppositeTurn() {
        return (turn.equals(Player.X) ? Player.O : Player.X);
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public Player[][] getBoard() {
        return board;
    }

    public void setBoard(Player[][] board) {
        this.board = board;
    }

    public int getMoveds() {
        return moveCounter;
    }

    public void setMoveds(int moveds) {
        this.moveCounter = moveds;
    }

}

