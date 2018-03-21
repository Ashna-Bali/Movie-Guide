package com.example.ashna.movieguide.api;

import com.example.ashna.movieguide.models.Genre;
import com.example.ashna.movieguide.models.MovieResponse;
import com.example.ashna.movieguide.models.TrailerResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ASHNA on 11-10-2017.
 */

public interface MovieDbApi {

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String api_key);

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String api_key);

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String api_key);

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String api_key);

    @GET("search/movie")
    Call<MovieResponse> getSearchedMovie(@Query("api_key") String api_key, @Query("query") String query);

    @GET("genre/movie/list")
    Call<ArrayList<Genre>> getGenreList(@Query("api_key") String api_key);

    @GET("genre/{genre_id}/movies")
    Call<MovieResponse> getGenreMovies(@Path("genre_id") int genre_id, @Query("api_key") String api_key);

    @GET("movie/{movie_id}/videos")
    Call<TrailerResponse> getMovieTrailers(@Path("movie_id") int movie_id, @Query("api_key") String api_key);
}
