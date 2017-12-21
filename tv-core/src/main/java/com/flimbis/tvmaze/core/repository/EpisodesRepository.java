package com.flimbis.tvmaze.core.repository;

import com.flimbis.tvmaze.core.entity.Episode;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Fifi on 12/10/2017.
 */

public interface EpisodesRepository extends BaseRepository<Episode>{
    Observable<List<Episode>> getAllPerShow(long showId);

    Observable<Episode> get(long id, int season, int episode);

}
