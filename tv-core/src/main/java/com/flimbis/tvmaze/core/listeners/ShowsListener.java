package com.flimbis.tvmaze.core.listeners;

import com.flimbis.tvmaze.core.entity.Shows;

import java.util.List;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface ShowsListener {
    void onSuccess(List<Shows> shows);

    void onError(String msg);
}
