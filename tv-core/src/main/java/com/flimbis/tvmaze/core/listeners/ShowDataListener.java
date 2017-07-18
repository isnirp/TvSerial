package com.flimbis.tvmaze.core.listeners;

import com.flimbis.tvmaze.core.entity.ShowsEntity;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface ShowDataListener {
    void onSuccess(ShowsEntity show);

    void onError(String msg);
}
