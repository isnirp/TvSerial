package com.flimbis.tvmaze.core.listeners;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface ShowDataListener {
    void onSuccess(ShowsEntity show);

    void onError(String msg);
}
