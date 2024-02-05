package com.example.ghidiemdanhbai.Model;

public class Match {
    private int matchId;
    private int matchGameId;
    private String matchPlayersNames;
    private String matchPlayersResults;

    public Match(int matchId, int matchGameId, String matchPlayersNames, String matchPlayersResults) {
        this.matchId = matchId;
        this.matchGameId = matchGameId;
        this.matchPlayersNames = matchPlayersNames;
        this.matchPlayersResults = matchPlayersResults;
    }

    public Match(int matchGameId, String matchPlayersNames, String matchPlayersResults) {
        this.matchGameId = matchGameId;
        this.matchPlayersNames = matchPlayersNames;
        this.matchPlayersResults = matchPlayersResults;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getMatchGameId() {
        return matchGameId;
    }

    public void setMatchGameId(int matchGameId) {
        this.matchGameId = matchGameId;
    }

    public String getMatchPlayersNames() {
        return matchPlayersNames;
    }

    public void setMatchPlayersNames(String matchPlayersNames) {
        this.matchPlayersNames = matchPlayersNames;
    }

    public String getMatchPlayersResults() {
        return matchPlayersResults;
    }

    public void setMatchPlayersResults(String matchPlayersResults) {
        this.matchPlayersResults = matchPlayersResults;
    }
}
