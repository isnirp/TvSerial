package com.flimbis.tvmaze.core.listeners;

import com.flimbis.tvmaze.core.entity.Episodes;

import java.util.List;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface EpisodeDataListener {
    void onSuccess(Episodes episode);

    void onError(String msg);
}
