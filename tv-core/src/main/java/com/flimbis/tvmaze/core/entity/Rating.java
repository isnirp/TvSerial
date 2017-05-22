package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fifi on 5/21/2017.
 */

public class Rating {
    @SerializedName("average")
    private double average;

    public Rating() {
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
