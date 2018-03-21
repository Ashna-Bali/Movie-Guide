package com.example.ashna.movieguide.models;

import java.util.ArrayList;

/**
 * Created by ASHNA on 15-10-2017.
 */

public class TrailerResponse {

    private int id;
    private ArrayList<Trailer> results;

    public TrailerResponse(int id, ArrayList<Trailer> results) {
        this.id = id;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Trailer> getResults() {
        return results;
    }
}
