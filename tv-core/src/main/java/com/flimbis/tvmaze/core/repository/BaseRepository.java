package com.flimbis.tvmaze.core.repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Fifi on 12/10/2017.
 */

public interface BaseRepository<T> {
    Observable<List<T>> getAll();

    Observable<T> getById(long id);
}
