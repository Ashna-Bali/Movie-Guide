package com.example.ashna.movieguide.models;

/**
 * Created by ASHNA on 14-10-2017.
 */

public class Genre {
    Integer id;
    String name;

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
