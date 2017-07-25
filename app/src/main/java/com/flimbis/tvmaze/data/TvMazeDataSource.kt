package com.flimbis.tvmaze.data

import android.util.Log
import com.flimbis.tvmaze.core.entity.EpisodesEntity
import com.flimbis.tvmaze.core.entity.ShowsEntity
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener
import com.flimbis.tvmaze.core.listeners.EpisodesListener
import com.flimbis.tvmaze.core.listeners.ShowDataListener
import com.flimbis.tvmaze.core.listeners.ShowsListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.model.*
import com.flimbis.tvmaze.data.remote.ApiService
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Fifi on 5/19/2017.
 */
class TvMazeDataSource(val apiService: ApiService) : TvMazeRepository {

    override fun getShowsListByPage(queryPageNumber: String): Observable<List<ShowsEntity>> {
        return apiService.getAllShowsByPage(queryPageNumber).
                map { transformToShowsEntityList(it) }
    }

    override fun getSelectedShowById(id: Long): Observable<ShowsEntity> {
        return apiService.getShowById(id).
                map { shows -> transformToShowsEntity(shows) }
    }

    override fun getShowEpisodesList(showId: Long): Observable<List<EpisodesEntity>> {
        return apiService.getShowAllEpisodes(showId).
                map { transformToEpisodesEntityList(it) }
    }

    override fun getSelectedEpisode(id: Long, querySeasonNumber: String, queryEpisodeNumber: String): Observable<EpisodesEntity> {
        return apiService.getShowEpisode(id, querySeasonNumber, queryEpisodeNumber).
                map { transformToEpisodesEntity(it) }
    }
}