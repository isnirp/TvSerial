package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fifi on 5/19/2017.
 */

public class Episodes {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("season")
    private int season;
    @SerializedName("number")
    private int number;
    @SerializedName("airdate")
    private String airdate;
    @SerializedName("airtime")
    private String airtime;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("image")
    private Image image;
    @SerializedName("summary")
    private String summary;

    public Episodes() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
