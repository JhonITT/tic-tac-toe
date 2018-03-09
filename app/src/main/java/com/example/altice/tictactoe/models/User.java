package com.example.altice.tictactoe.models;

/**
 * Created by JmFernandezA on 09/03/2018.
 */

public class User {
    public String username;
    public String password;
    public Player player;

    public User(String username, String password, Player player) {
        this.username = username;
        this.password = password;
        this.player = player;
    }
}
