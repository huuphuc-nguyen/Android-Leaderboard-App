package edu.utsa.cs3443.leaderboard.model;

import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<Player> players;

    public LeaderBoard(){
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void loadPlayer(){
        addPlayer(new Player("Felix", 220, ""));
        addPlayer(new Player("1Felix", 220, ""));
        addPlayer(new Player("2Felix", 220, ""));
        addPlayer(new Player("3Felix", 220, ""));
    }

    public void savePlayer(){
        // TODO
    }
}
