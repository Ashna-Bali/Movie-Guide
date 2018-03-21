package com.example.ashna.movieguide.database.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ashna.movieguide.models.Movie;

import java.util.ArrayList;

import static com.example.ashna.movieguide.database.tables.DbConsts.*;

/**
 * Created by ASHNA on 26-10-2017.
 */

public class FavoriteTable {

    public static final String TABLE_NAME = "favorites";

    public interface Columns {
        String ID = "id";
        String TITLE = "title";
        String POSTER_PATH = "poster_path";
        String RELEASE_DATE = "release_date";
        String RATING = "rating";
        String OVERVIEW = "overview";
        String BACKDROP_PATH = "backdrop_path";
        String ADULT = "adult";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR + Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA +
                    Columns.BACKDROP_PATH + TYPE_TEXT + COMMA +
                    Columns.POSTER_PATH + TYPE_TEXT + COMMA +
                    Columns.TITLE + TYPE_TEXT + COMMA +
                    Columns.RELEASE_DATE + TYPE_TEXT + COMMA +
                    Columns.RATING + TYPE_REAL + COMMA +
                    Columns.OVERVIEW + TYPE_TEXT + COMMA +
                    Columns.ADULT + TYPE_BOOL + RBR + SEMI;

    public static ArrayList<Movie> getAllFavourites(SQLiteDatabase db) {
        ArrayList<Movie> movies = new ArrayList<>();

        Cursor c = db.query(
                TABLE_NAME,
                new String[]{Columns.ID, Columns.BACKDROP_PATH, Columns.POSTER_PATH, Columns.TITLE,
                        Columns.RELEASE_DATE, Columns.RATING, Columns.OVERVIEW, Columns.ADULT},
                null,
                null,
                null,
                null,
                null
        );

        int idIndex = c.getColumnIndex(Columns.ID);
        int backdropIndex = c.getColumnIndex(Columns.BACKDROP_PATH);
        int titleIndex = c.getColumnIndex(Columns.TITLE);
        int releaseDateIndex = c.getColumnIndex(Columns.RELEASE_DATE);
        int ratingIndex = c.getColumnIndex(Columns.RATING);
        int overviewIndex = c.getColumnIndex(Columns.OVERVIEW);
        int adultIndex = c.getColumnIndex(Columns.ADULT);
        int posterIndex = c.getColumnIndex(Columns.POSTER_PATH);

        while (c.moveToNext()) {

            movies.add(
                    new Movie(
                            c.getInt(idIndex),
                            c.getString(backdropIndex),
                            c.getString(posterIndex),
                            c.getString(titleIndex),
                            c.getString(releaseDateIndex),
                            c.getDouble(ratingIndex),
                            c.getString(overviewIndex),
                            c.getInt(adultIndex)!=0
                    )
            );
        }

        return movies;
    }

    public static long insertFavorite(Movie movie, SQLiteDatabase db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.RATING, movie.getVote_average());
        contentValues.put(Columns.TITLE, movie.getTitle());
        contentValues.put(Columns.BACKDROP_PATH, movie.getBackdropPath());
        contentValues.put(Columns.ADULT, movie.isAdult());
        contentValues.put(Columns.ID, movie.getId());
        contentValues.put(Columns.RELEASE_DATE, movie.getRelease_date());
        contentValues.put(Columns.POSTER_PATH, movie.getPosterPath());
        contentValues.put(Columns.OVERVIEW, movie.getOverview());
        return db.insert(
                TABLE_NAME,
                null,
                contentValues
        );
    }

    public static long deleteFavorite(int id, SQLiteDatabase db){

        return db.delete(
                TABLE_NAME,
                Columns.ID + "=" + LIC + id + RIC ,
                null
        );

    }
}
