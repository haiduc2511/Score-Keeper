package com.example.ghidiemdanhbai.Model;

import android.graphics.Bitmap;

public class Player {
    private int playerId;

    public Player(int playerId, String playerName, int timesPlayed, int playerImage) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.timesPlayed = timesPlayed;
        this.playerImage = playerImage;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    private String playerName;
    private int timesPlayed;
    private int playerImage;

    public Player(String playerName, int timesPlayed, int playerImage) {
        this.playerName = playerName;
        this.timesPlayed = timesPlayed;
        this.playerImage = playerImage;
    }

    public Player(String playerName, int playerImage) {
        this.playerName = playerName;
        this.playerImage = playerImage;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public int getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(int playerImage) {
        this.playerImage = playerImage;
    }
}
