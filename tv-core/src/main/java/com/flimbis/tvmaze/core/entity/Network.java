package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fifi on 5/21/2017.
 */

public class Network {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private Country country;

    public Network() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
