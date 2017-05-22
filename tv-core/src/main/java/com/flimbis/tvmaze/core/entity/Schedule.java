package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fifi on 5/21/2017.
 */

public class Schedule {
    @SerializedName("time")
    private String time;
    @SerializedName("days")
    private List<String> days;

    public Schedule() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
