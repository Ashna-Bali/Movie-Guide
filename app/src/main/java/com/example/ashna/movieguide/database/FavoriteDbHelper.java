package com.example.ashna.movieguide.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ashna.movieguide.database.tables.FavoriteTable;

/**
 * Created by ASHNA on 26-10-2017.
 */

public class FavoriteDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "favorites.db";
    public static final int DB_VER = 1;

    public FavoriteDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(FavoriteTable.CMD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
