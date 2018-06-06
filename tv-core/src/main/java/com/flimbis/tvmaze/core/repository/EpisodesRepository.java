package com.flimbis.tvmaze.core.repository;

import com.flimbis.tvmaze.core.entity.EpisodeEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Fifi on 12/10/2017.
 */

public interface EpisodesRepository extends BaseRepository<EpisodeEntity>{
    Observable<List<EpisodeEntity>> getAllShowsEpisodes(long showId);

    Single<EpisodeEntity> get(long id, int season, int episode);
}
