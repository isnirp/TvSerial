package com.flimbis.tvmaze.core.entity;

import java.util.List;

/**
 * Created by Fifi on 12/10/2017.
 */

public class ShowEntity {
    private long id;
    private String name;
    private List<String> genres;
    private String status;
    private ScheduleEntity schedule;
    private String image;
    private String summary;
    private String tvMazeInfo;//url that links to detailed info from tv maze

    public ShowEntity() {
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleEntity schedule) {
        this.schedule = schedule;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTvMazeInfo() {
        return tvMazeInfo;
    }

    public void setTvMazeInfo(String tvMazeInfo) {
        this.tvMazeInfo = tvMazeInfo;
    }
}
