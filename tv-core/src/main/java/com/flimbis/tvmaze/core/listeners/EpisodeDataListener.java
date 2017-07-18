package com.flimbis.tvmaze.core.listeners;

import com.flimbis.tvmaze.core.entity.EpisodesEntity;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface EpisodeDataListener {
    void onSuccess(EpisodesEntity episode);

    void onError(String msg);
}
