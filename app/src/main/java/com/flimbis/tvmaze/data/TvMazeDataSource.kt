package com.flimbis.tvmaze.data

import com.flimbis.tvmaze.core.entity.Episodes
import com.flimbis.tvmaze.core.entity.Shows
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener
import com.flimbis.tvmaze.core.listeners.EpisodesListener
import com.flimbis.tvmaze.core.listeners.ShowDataListener
import com.flimbis.tvmaze.core.listeners.ShowsListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Fifi on 5/19/2017.
 */
class TvMazeDataSource(val apiService: ApiService) : TvMazeRepository {

    override fun getShowsListByPage(queryPageNumber: String, listener: ShowsListener?) {
        apiService.getAllShowsByPage(queryPageNumber).enqueue(object : Callback<List<Shows>?> {
            override fun onFailure(call: Call<List<Shows>?>?, t: Throwable?) {
                listener?.onError(t?.message)
            }

            override fun onResponse(call: Call<List<Shows>?>?, response: Response<List<Shows>?>?) {
                listener?.onSuccess(response?.body())
            }
        })
    }

    override fun getShowEpisodesList(showId: Long, listener: EpisodesListener?) {
        apiService.getShowAllEpisodes(showId).enqueue(object : Callback<List<Episodes>?> {
            override fun onFailure(call: Call<List<Episodes>?>?, t: Throwable?) {
                listener?.onError(t?.message)
            }

            override fun onResponse(call: Call<List<Episodes>?>?, response: Response<List<Episodes>?>?) {
                listener?.onSuccess(response?.body())
            }
        })
    }

    override fun getSelectedShowById(id: Long, listener: ShowDataListener?) {
        apiService.getShowById(id).enqueue(object : Callback<Shows?> {
            override fun onResponse(call: Call<Shows?>?, response: Response<Shows?>?) {
                listener?.onSuccess(response?.body())
            }

            override fun onFailure(call: Call<Shows?>?, t: Throwable?) {
                listener?.onError(t?.message)

            }
        })
    }

    override fun getSelectedEpisode(id: Long, querySeasonNumber: String, queryEpisodeNumber: String, listener: EpisodeDataListener?) {
        apiService.getShowEpisode(id, querySeasonNumber, queryEpisodeNumber).enqueue(object : Callback<Episodes?> {
            override fun onResponse(call: Call<Episodes?>?, response: Response<Episodes?>?) {
                listener?.onSuccess(response?.body())
            }

            override fun onFailure(call: Call<Episodes?>?, t: Throwable?) {
                listener?.onError(t?.message)
            }
        })
    }
}