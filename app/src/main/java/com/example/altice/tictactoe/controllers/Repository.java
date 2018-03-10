package com.example.altice.tictactoe.controllers;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.altice.tictactoe.models.Mode;
import com.example.altice.tictactoe.models.PlayHistory;
import com.example.altice.tictactoe.models.Player;
import com.example.altice.tictactoe.models.State;
import com.example.altice.tictactoe.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 09/03/18.
 */

public class Repository {
    public static Repository instance;
    public User playerOne;
    public User playerTwo;
    public List<PlayHistory> playHistories;
    public Mode mode;

    static {
        instance = new Repository();
    }

    private Repository(){
        playerOne = new User();
        playerTwo = new User();
        playHistories = new ArrayList<>();
        mode = Mode.OnePlayer;
    }
    public void insertEvent(State state){
        playHistories.add(new PlayHistory(playerOne.username,playerTwo.username,state));
    }

    public int getScore(){
        return getWins() - getLoses();
    }

    public void changePlayer(){
        if (playerOne.player.equals(Player.X)){
            playerOne.player = Player.O;
            playerTwo.player = Player.X;
        }else{
            playerOne.player = Player.X;
            playerTwo.player = Player.O;
        }
    }

    public int getWins(){
        int count = 0;
        for (PlayHistory ph : playHistories) {
            count += ph.state.equals(State.WIN) ? 1 : 0;
        }
        return count;
    }

    public int getLoses(){
        int count = 0;
        for (PlayHistory ph : playHistories) {
            count += ph.state.equals(State.LOSE) ? 1 : 0;
        }
        return count;
    }

    public int getDraws(){
        int count = 0;
        for (PlayHistory ph : playHistories) {
            count += ph.state.equals(State.DRAW) ? 1 : 0;
        }
        return count;
    }


    public List<String> histories() {
        List<String> list = new ArrayList<>();
        for (PlayHistory ph: playHistories) {
            list.add("P1:       "+ph.playerOne+" P2:        "+ph.playerTwo+"    -->     "+ph.state);
        }
        return list;
    }
}
