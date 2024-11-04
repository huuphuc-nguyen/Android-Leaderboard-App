package edu.utsa.cs3443.leaderboard.model;

import android.app.Activity;

import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<Player> players;
    private Activity activity;

    public LeaderBoard(Activity activity){
        this.players = new ArrayList<>();
        this.activity = activity;
    }

    public void addPlayer(Player player){
        players.add(player);
    }



    public void loadPlayer(){
        // TODO: create file or read from file
        addPlayer(new Player("Felix", 220));
        addPlayer(new Player("1Felix", 220));
        addPlayer(new Player("2Felix", 220));
        addPlayer(new Player("3Felix", 220));addPlayer(new Player("Felix", 220));
        addPlayer(new Player("1Felix", 220));
        addPlayer(new Player("2Felix", 220));
        addPlayer(new Player("3Felix", 220));addPlayer(new Player("Felix", 220));
        addPlayer(new Player("1Felix", 220));
        addPlayer(new Player("2Felix", 220));
        addPlayer(new Player("3Felix", 220));addPlayer(new Player("Felix", 220));
        addPlayer(new Player("1Felix", 220));
        addPlayer(new Player("2Felix", 220));
        addPlayer(new Player("3Felix", 220));
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void savePlayer(){
        // TODO
    }
}
