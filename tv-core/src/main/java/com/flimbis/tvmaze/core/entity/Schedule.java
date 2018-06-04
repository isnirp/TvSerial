package com.flimbis.tvmaze.core.entity;

import java.util.List;

/**
 * Created by Fifi on 6/5/2018.
 */

public class Schedule {
    private String time;
    private List<String> days;

    public Schedule(String time, List<String> days) {
        this.time = time;
        this.days = days;
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
