package edu.utsa.cs3443.leaderboard.model;

public class Player {
    private String name;
    private int score;
    private String imgUrl;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.imgUrl = "https://mighty.tools/mockmind-api/content/human/65.jpg";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
