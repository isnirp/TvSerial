package com.flimbis.tvmaze.core.listeners;

import com.flimbis.tvmaze.core.entity.ShowsEntity;

import java.util.List;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface ShowsListener {
    void onSuccess(List<ShowsEntity> shows);

    void onError(String msg);
}
