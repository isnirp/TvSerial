package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fifi on 5/19/2017.
 */

public class Shows {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private Image image;

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
}
