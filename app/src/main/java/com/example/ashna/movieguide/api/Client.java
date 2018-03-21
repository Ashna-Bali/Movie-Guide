package com.example.ashna.movieguide.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASHNA on 10-10-2017.
 */

public class Client {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create()).build();


    MovieDbApi movieDbApi = retrofit.create(MovieDbApi.class);
    public Retrofit getRetrofit() {
        return retrofit;
    }

    public MovieDbApi getApi() {
        return movieDbApi;
    }

    private Client(){}
    private static final Client ourInstance = new Client();

    public static Client getInstance() {
        return ourInstance;
    }
}
