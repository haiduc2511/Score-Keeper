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

    public static final String DATABASE = "player.db";

    public static String DATABASE_CREATE = "create table "
            + TABLE_PLAYER
            + "( " + COLUMN_PLAYER_ID + " integer primary key autoincrement, "
            + COLUMN_PLAYER_NAME + " text not null,"
            + COLUMN_PLAYER_TIMES_PLAYED + " integer not null,"
            + COLUMN_PLAYER_IMAGE + " text not null);";



    public MySQLiteHelper(Context context) {
        super(context, DATABASE_CREATE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

