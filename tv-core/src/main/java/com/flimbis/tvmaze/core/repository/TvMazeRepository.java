package com.flimbis.tvmaze.core.repository;

import com.flimbis.tvmaze.core.entity.Episodes;
import com.flimbis.tvmaze.core.entity.Shows;
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener;
import com.flimbis.tvmaze.core.listeners.EpisodesListener;
import com.flimbis.tvmaze.core.listeners.ShowDataListener;
import com.flimbis.tvmaze.core.listeners.ShowsListener;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface TvMazeRepository {

    Observable<List<Shows>> getShowsListByPage(final String queryPageNumber);

    Observable<Shows> getSelectedShowById(final long id);

    Observable<List<Episodes>> getShowEpisodesList(final long showId);

    Observable<Episodes> getSelectedEpisode(final long id, final String querySeasonNumber, final String queryEpisodeNumber);

}
