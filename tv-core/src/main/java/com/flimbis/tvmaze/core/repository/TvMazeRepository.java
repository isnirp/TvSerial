package com.flimbis.tvmaze.core.repository;

import com.flimbis.tvmaze.core.entity.EpisodesEntity;
import com.flimbis.tvmaze.core.entity.ShowsEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface TvMazeRepository {

    Observable<List<ShowsEntity>> getShowsListByPage(final String queryPageNumber);

    Observable<ShowsEntity> getSelectedShowById(final long id);

    Observable<List<EpisodesEntity>> getShowEpisodesList(final long showId);

    Observable<EpisodesEntity> getSelectedEpisode(final long id, final String querySeasonNumber, final String queryEpisodeNumber);

}
