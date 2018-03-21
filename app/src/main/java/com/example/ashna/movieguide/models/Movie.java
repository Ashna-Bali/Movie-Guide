package com.example.ashna.movieguide.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ASHNA on 10-10-2017.
 */

public class Movie {
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("genre_ids")
    private ArrayList<Integer> genre_ids;
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer vote_count;
    @SerializedName("video")
    private Boolean video;
    @SerializedName("vote_average")
    private Double vote_average;

    public Movie(Integer id, String backdrop_path, String poster_path, String title, String release_date, Double vote_average, String overview, Boolean adult) {
        this.overview = overview;
        this.release_date = release_date;
        this.id = id;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
        this.adult = adult;
        this.poster_path = poster_path;
    }

    public Movie(String poster_path, boolean adult, String overview, String release_date, ArrayList<Integer> genre_ids, Integer id, String original_title, String original_language, String title, String backdrop_path, Double popularity, Integer vote_count, Boolean video, Double vote_average) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
    }


    String baseImageUrl = "https://image.tmdb.org/t/p/w500";

    public String getPoster_path() { return "https://image.tmdb.org/t/p/w500"+poster_path; }

    public String getPosterPath() { return poster_path; }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return "https://image.tmdb.org/t/p/w500"+backdrop_path;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVote_average() {
        return vote_average;
    }
}
