package com.flimbis.tvmaze.data

import android.util.Log
import com.flimbis.tvmaze.core.entity.Episodes
import com.flimbis.tvmaze.core.entity.Shows
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener
import com.flimbis.tvmaze.core.listeners.EpisodesListener
import com.flimbis.tvmaze.core.listeners.ShowDataListener
import com.flimbis.tvmaze.core.listeners.ShowsListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.remote.ApiService
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Fifi on 5/19/2017.
 */
class TvMazeDataSource(val apiService: ApiService) : TvMazeRepository {

    override fun getShowsListByPage(queryPageNumber: String): Observable<List<Shows>> {
        return apiService.getAllShowsByPage(queryPageNumber)
    }

    override fun getSelectedShowById(id: Long): Observable<Shows> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShowEpisodesList(showId: Long): Observable<MutableList<Episodes>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSelectedEpisode(id: Long, querySeasonNumber: String?, queryEpisodeNumber: String?): Observable<Episodes> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}