package com.example.altice.tictactoe.models;

/**
 * Created by JmFernandezA on 09/03/2018.
 */

public class User {
    public String username;
    public Player player;

    public User() {

    }
    public User(String username, Player player) {
        this.username = username;
        this.player = player;
    }

}
