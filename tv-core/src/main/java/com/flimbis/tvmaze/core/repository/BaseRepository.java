package com.flimbis.tvmaze.core.repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Fifi on 12/10/2017.
 */

public interface BaseRepository<T> {
    /*
    * shows are paginated
    * seasons require show id
    * episodes require season id
    * */
    Observable<List<T>> getAll(long id);

    Single<T> get(long id);
}
