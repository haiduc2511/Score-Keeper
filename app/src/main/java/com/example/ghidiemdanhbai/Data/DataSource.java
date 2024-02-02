package com.example.ghidiemdanhbai.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ghidiemdanhbai.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private MySQLiteHelper sqLiteHelper;
    private SQLiteDatabase database;
    private String[] allColumns = {MySQLiteHelper.COLUMN_PLAYER_ID,
            MySQLiteHelper.COLUMN_PLAYER_NAME,
            MySQLiteHelper.COLUMN_PLAYER_TIMES_PLAYED,
            MySQLiteHelper.COLUMN_PLAYER_IMAGE};

    public DataSource(Context context) {
        sqLiteHelper = new MySQLiteHelper(context);
    }

    public void open() {
        database = sqLiteHelper.getWritableDatabase();
    }

    public void close() {
        sqLiteHelper.close();
    }

    public void addNewPlayer(Player player) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_NAME, player.getPlayerName());
        cv.put(MySQLiteHelper.COLUMN_PLAYER_TIMES_PLAYED, player.getTimesPlayed());
        cv.put(MySQLiteHelper.COLUMN_PLAYER_IMAGE, player.getPlayerImage());
        database.insert(MySQLiteHelper.TABLE_PLAYER, null, cv);
    }

    public void deletePlayer(Player player) {
        database.delete(MySQLiteHelper.TABLE_PLAYER,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = " + player.getPlayerId() , null);
    }

    public List<Player> getAllPlayersFromDatabase() {
        List<Player> players = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PLAYER,
                allColumns, null, null, null, null, null);

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

    public void updateName(int id, String playerName) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_NAME, playerName);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void updateTimesPlayed(int id, int playerTimesPlayed) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_TIMES_PLAYED, playerTimesPlayed);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void updateImage(int id, int playerImage) {
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_PLAYER_IMAGE, playerImage);
        database.update(MySQLiteHelper.TABLE_PLAYER, cv,
                MySQLiteHelper.COLUMN_PLAYER_ID + " = ?", new String[] {String.valueOf(id)});
    }

}

