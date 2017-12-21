package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fifi on 12/10/2017.
 */

public class Episode {
    private long id;
    private String name;
    private int season;
    private int number;
    private String airDate;
    private String airTime;
    private int runTime;
    private Image image;
    private String summary;

    public Episode() {
    }

    public Episode(long id, String name, int season, int number, String airDate, String airTime, int runTime, Image image, String summary) {
        this.id = id;
        this.name = name;
        this.season = season;
        this.number = number;
        this.airDate = airDate;
        this.airTime = airTime;
        this.runTime = runTime;
        this.image = image;
        this.summary = summary;
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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
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
