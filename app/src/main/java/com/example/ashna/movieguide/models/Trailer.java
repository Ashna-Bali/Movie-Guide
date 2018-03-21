package com.example.ashna.movieguide.models;

/**
 * Created by ASHNA on 15-10-2017.
 */

public class Trailer {
    private String key;
    private String name;

    public Trailer(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
