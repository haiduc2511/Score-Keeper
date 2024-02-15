package com.example.ghidiemdanhbai.ViewModel;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.Model.Player;

import java.util.List;

public class GameViewModel {

    private List<Game> games;
    private DataSource dataSource;

    public GameViewModel(DataSource dataSource) {
        this.dataSource = dataSource;
        dataSource.open();
        this.games = this.getAllGames();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Game> getAllGames() {
        return dataSource.getAllGamesFromDatabase();
    }
    public void addNewGame(Game game) {
        dataSource.addNewGame(game);
    }

    public Game getLatestGame() {
        return dataSource.getLatestGameFromDatabase();
    }
    public void deleteGame(Game game) {dataSource.deleteGame(game);}

    public Game getGameById(int id) {
        for (Game game : games) {
            if (game.getGameId() == id) {
                return game;
            }
        }
        return new Game("", 0 , "");
    }


}
