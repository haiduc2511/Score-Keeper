package com.example.ghidiemdanhbai.ViewModel;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.Model.Match;
import com.example.ghidiemdanhbai.Utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MatchViewModel {

    private List<Match> matches;
    private DataSource dataSource;
    private Game game;

    public MatchViewModel(DataSource dataSource, Game game) {
        this.dataSource = dataSource;
        this.game = game;
        dataSource.open();
        this.matches = this.getAllMatches();
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    public void addNewMatch(Match match) {dataSource.addNewMatch(match);}

    private List<Match> getAllMatches() {
        return dataSource.getAllMatchesFromGameFromDatabase(game);
    }

    public List<String> getListResult() {
        List<String> playersNamesList = StringUtils.convertStringToArrayList(getGame().getGamePlayersNames());
        List<String> resultsList = new ArrayList<>();
        for (int i = 0; i < matches.size(); i++) {
            List<String> matchResultList = StringUtils.convertStringToArrayList(matches.get(i).getMatchPlayersResults());
            for (int j = 0; j < game.getGameNumberOfPlayers(); j++) {
                resultsList.add(playersNamesList.get(j) + " " + matchResultList.get(j));
            }
        }
        return resultsList;
    }
}
