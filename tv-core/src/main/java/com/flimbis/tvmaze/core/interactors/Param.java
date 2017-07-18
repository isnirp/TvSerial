package com.flimbis.tvmaze.core.interactors;

/**
 * Created by Fifi on 7/18/2017.
 */

public class Param {
    private String queryPageNumber;
    private long id;
    private String querySeasonNumber;
    private String queryEpisodeNumber;

    public Param(long id) {
        this.id = id;
    }

    public Param(String queryPageNumber) {
        this.queryPageNumber = queryPageNumber;
    }

    public Param(long id, String querySeasonNumber, String queryEpisodeNumber) {
        this.id = id;
        this.querySeasonNumber = querySeasonNumber;
        this.queryEpisodeNumber = queryEpisodeNumber;
    }

    public String getQueryPageNumber() {
        return queryPageNumber;
    }

    public long getId() {
        return id;
    }

    public String getQuerySeasonNumber() {
        return querySeasonNumber;
    }

    public String getQueryEpisodeNumber() {
        return queryEpisodeNumber;
    }
}
