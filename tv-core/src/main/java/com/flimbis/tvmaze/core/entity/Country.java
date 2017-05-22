package com.flimbis.tvmaze.core.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fifi on 5/21/2017.
 */

public class Country {
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("timezone")
    private String timezone;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
