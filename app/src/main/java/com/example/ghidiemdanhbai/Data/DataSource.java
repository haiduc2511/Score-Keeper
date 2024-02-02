package com.example.ghidiemdanhbai.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private MySQLiteHelper sqLiteHelper;
    private SQLiteDatabase database;
    private String[] allPlayerColumns = {MySQLiteHelper.COLUMN_PLAYER_ID,
            MySQLiteHelper.COLUMN_PLAYER_NAME,
            MySQLiteHelper.COLUMN_PLAYER_TIMES_PLAYED,
            MySQLiteHelper.COLUMN_PLAYER_IMAGE};
    private String[] allGameColumns = {MySQLiteHelper.COLUMN_GAME_ID,
            MySQLiteHelper.COLUMN_GAME_PLAYERS_NAMES,
            MySQLiteHelper.COLUMN_GAME_NUMBER_OF_PLAYERS,
            MySQLiteHelper.COLUMN_GAME_DATE};

    public DataSource(Context context) {
        sqLiteHelper = new MySQLiteHelper(context);
    }

    public void open() {
        database = sqLiteHelper.getWritableDatabase();
    }

    public void close() {
        sqLiteHelper.close();
    }

    //Add and Delete
    public void addNewPlayer(Player player) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_NAME, player.getPlayerName());
        cv.put(MySQLiteHelper.COLUMN_PLAYER_TIMES_PLAYED, player.getTimesPlayed());
        cv.put(MySQLiteHelper.COLUMN_PLAYER_IMAGE, player.getPlayerImage());
        database.insert(MySQLiteHelper.TABLE_PLAYER, null, cv);
    }
    public void addNewGame(Game game) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_GAME_ID, game.getGameId());
        cv.put(MySQLiteHelper.COLUMN_GAME_NUMBER_OF_PLAYERS, game.getGameNumberOfPlayers());
        cv.put(MySQLiteHelper.COLUMN_GAME_DATE, game.getGameDate());
        database.insert(MySQLiteHelper.TABLE_GAME, null, cv);
    }



    public void deletePlayer(Player player) {
        database.delete(MySQLiteHelper.TABLE_PLAYER,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = " + player.getPlayerId() , null);
    }

    //Get All
    public List<Player> getAllPlayersFromDatabase() {
        List<Player> players = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PLAYER,
                allPlayerColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Player player = new Player(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3));
            players.add(player);
            cursor.moveToNext();
        }

        cursor.close();
        return players;
    }
    public List<Game> getAllGamesFromDatabase() {
        List<Game> games = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_GAME,
                allGameColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Game game = new Game(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3));
            games.add(game);
            cursor.moveToNext();
        }

        cursor.close();
        return games;
    }


    //Update
    public void updatePlayerName(int id, String playerName) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_NAME, playerName);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void updatePlayerTimesPlayed(int id, int playerTimesPlayed) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_TIMES_PLAYED, playerTimesPlayed);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void updatePlayerImage(int id, int playerImage) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_IMAGE, playerImage);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = ?", new String[] {String.valueOf(id)});
    }
    public void updateGamePlayersNames(int id, int gamePlayersNames) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_GAME_PLAYERS_NAMES, gamePlayersNames);
        database.update(MySQLiteHelper.TABLE_GAME, cv,
                MySQLiteHelper.COLUMN_GAME_ID + " = ?", new String[] {String.valueOf(id)});
    }
    public void updateGameNumberOfPlayers(int id, int gameNumberOfPlayers) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_GAME_NUMBER_OF_PLAYERS, gameNumberOfPlayers);
        database.update(MySQLiteHelper.TABLE_GAME, cv,
                MySQLiteHelper.COLUMN_GAME_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void updateGameDate(int id, String gameDate) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_GAME_DATE, gameDate);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_GAME_ID + " = ?", new String[] {String.valueOf(id)});
    }

}

