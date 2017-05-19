package com.flimbis.tvmaze.core.repository;

import com.flimbis.tvmaze.core.entity.Shows;
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener;
import com.flimbis.tvmaze.core.listeners.EpisodesListener;
import com.flimbis.tvmaze.core.listeners.ShowDataListener;
import com.flimbis.tvmaze.core.listeners.ShowsListener;

import java.util.List;

/**
 * Created by Fifi on 5/19/2017.
 */

public interface TvMazeRepository {

    //get Shows by Pagination
    void getShowsListByPage(final String queryPageNumber, ShowsListener listener);

    //get Shows by id
    void getSelectedShowById(final long id, ShowDataListener listener);

    //get Shows's episodes
    void getShowEpisodesList(final long showId, EpisodesListener listener);

    //get an episode
    void getSelectedEpisode(final long id, final String querySeasonNumber, final String queryEpisodeNumber, EpisodeDataListener listener);
}
