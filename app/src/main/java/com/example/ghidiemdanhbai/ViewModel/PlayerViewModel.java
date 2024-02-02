package com.example.ghidiemdanhbai.ViewModel;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerViewModel {

    private List<Player> players;
    private DataSource dataSource;
    private Set<Integer> playersChecked;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Set<Integer> getPlayersChecked() {
        return playersChecked;
    }

    public void setPlayersChecked(Set<Integer> playersChecked) {
        this.playersChecked = playersChecked;
    }

    public ArrayList<String> getPlayersForNewGame() {
        ArrayList<String> playersNames = new ArrayList<>();
        for (Integer i : playersChecked) {
            Player player = players.get(i);
            playersNames.add(player.getPlayerName());
            this.incrementTimesPlayed(player);
        }
        return playersNames;
    }

    public PlayerViewModel(DataSource dataSource) {
        this.dataSource = dataSource;
        playersChecked = new HashSet<>();
        dataSource.open();
        this.players = this.getAllPlayers();

    }

    public List<Player> getAllPlayers() {
        return dataSource.getAllPlayersFromDatabase();
    }

    public void addNewPlayer(Player player) {
        dataSource.addNewPlayer(player);
    }

    public void changePlayerName(Player player, String newName) {
        player.setPlayerName(newName);
        dataSource.updateName(player.getPlayerId(), newName);
    }

    public void incrementTimesPlayed(Player player) {
        player.setTimesPlayed(player.getTimesPlayed() + 1);
        dataSource.updateTimesPlayed(player.getPlayerId(), player.getTimesPlayed());
    }

}
