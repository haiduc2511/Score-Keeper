package com.example.ghidiemdanhbai.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_PLAYER = "player";
    public static final String COLUMN_PLAYER_ID = "playerID";
    public static final String COLUMN_PLAYER_NAME = "playerName";
    public static final String COLUMN_PLAYER_TIMES_PLAYED = "playerTimesPlayed";
    public static final String COLUMN_PLAYER_IMAGE = "playerImage";

    public static final String DATABASE = "GhiDiemDanhBai.db";

    public static String PLAYER_TABLE_CREATE = "create table "
            + TABLE_PLAYER
            + "( " + COLUMN_PLAYER_ID + " integer primary key autoincrement, "
            + COLUMN_PLAYER_NAME + " text not null,"
            + COLUMN_PLAYER_TIMES_PLAYED + " integer not null,"
            + COLUMN_PLAYER_IMAGE + " text not null);";

    public static final String TABLE_GAME = "game";
    public static final String COLUMN_GAME_ID = "gameID";
    public static final String COLUMN_GAME_PLAYERS_NAMES = "gamePlayersNames";
    public static final String COLUMN_GAME_NUMBER_OF_PLAYERS = "gameNumberOfPlayers";
    public static final String COLUMN_GAME_DATE = "gameDate";

    public static String GAME_TABLE_CREATE = "create table "
            + TABLE_GAME
            + "( " + COLUMN_GAME_ID + " integer primary key autoincrement, "
            + COLUMN_GAME_PLAYERS_NAMES + " text not null,"
            + COLUMN_GAME_NUMBER_OF_PLAYERS + " text not null,"
            + COLUMN_GAME_DATE + " text not null);";
    public static final String TABLE_MATCH = "match_table";
    public static final String COLUMN_MATCH_ID = "matchID";
    public static final String COLUMN_MATCH_GAME_ID = "matchGameID";
    public static final String COLUMN_MATCH_PLAYERS_NAMES = "matchPlayersNames";
    public static final String COLUMN_MATCH_PLAYERS_RESULTS = "matchPlayersResults";

    public static String MATCH_TABLE_CREATE = "create table "
            + TABLE_MATCH
            + "( " + COLUMN_MATCH_ID + " integer primary key autoincrement, "
            + COLUMN_MATCH_GAME_ID + " integer not null,"
            + COLUMN_MATCH_PLAYERS_NAMES + " text not null,"
            + COLUMN_MATCH_PLAYERS_RESULTS + " text not null);";



    public MySQLiteHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PLAYER_TABLE_CREATE);
        db.execSQL(GAME_TABLE_CREATE);
        db.execSQL(MATCH_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

