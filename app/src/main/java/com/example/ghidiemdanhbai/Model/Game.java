package com.example.ghidiemdanhbai.Model;

public class Game {
    private int gameId;
    private String gamePlayersNames;
    private int gameNumberOfPlayers;
    private String gameDate;

    public Game(int gameId, String gamePlayersNames, int gameNumberOfPlayers, String gameDate) {
        this.gameId = gameId;
        this.gamePlayersNames = gamePlayersNames;
        this.gameNumberOfPlayers = gameNumberOfPlayers;
        this.gameDate = gameDate;
    }

    public Game(String gamePlayersNames, int gameNumberOfPlayers, String gameDate) {
        this.gamePlayersNames = gamePlayersNames;
        this.gameNumberOfPlayers = gameNumberOfPlayers;
        this.gameDate = gameDate;
    }

    public String getGamePlayersNames() {
        return gamePlayersNames;
    }

    public void setGamePlayersNames(String gamePlayersNames) {
        this.gamePlayersNames = gamePlayersNames;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameNumberOfPlayers() {
        return gameNumberOfPlayers;
    }

    public void setGameNumberOfPlayers(int gameNumberOfPlayers) {
        this.gameNumberOfPlayers = gameNumberOfPlayers;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }
}
