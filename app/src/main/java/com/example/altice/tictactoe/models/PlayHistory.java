package com.example.altice.tictactoe.models;

/**
 * Created by jhon on 09/03/18.
 */

public class PlayHistory {
    public String playerOne;
    public String playerTwo;
    public State state;

    public PlayHistory(String playerOne, String playerTwo, State state) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.state = state;
    }
}
