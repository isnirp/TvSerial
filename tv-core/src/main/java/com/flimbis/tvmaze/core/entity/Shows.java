package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fifi on 5/19/2017.
 */

public class Shows {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("language")
    private String language;
    @SerializedName("genres")
    private List<String> genres;
    @SerializedName("status")
    private String status;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("premiered")
    private String premiered;
    @SerializedName("schedule")
    private Schedule schedule;
    @SerializedName("rating")
    private Rating rating;
    @SerializedName("network")
    private Network network;
    @SerializedName("image")
    private Image image;
    @SerializedName("summary")
    private String summary;


    public Shows() {
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
