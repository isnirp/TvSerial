package com.flimbis.tvmaze.data.remote

import com.flimbis.tvmaze.core.entity.EpisodesEntity
import com.flimbis.tvmaze.core.entity.ShowsEntity
import com.flimbis.tvmaze.data.model.Episodes
import com.flimbis.tvmaze.data.model.Shows
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Fifi on 5/19/2017.
 */
interface ApiService {
    @GET("shows?page=1")   //http://api.tvmaze.com/shows
    fun getAllShowsTv(): Observable<List<Shows>>

    @GET("shows")   // http://api.tvmaze.com/shows?page=1 250 items per page
    fun getAllShowsByPage(@Query("page") pageNumber: String): Observable<List<Shows>>

    @GET("shows/{id}")  //http://api.tvmaze.com/shows/1
    fun getShowById(@Path("id") id: Long): Observable<Shows>

    @GET("shows/{id}/episodes") //http://api.tvmaze.com/shows/1/episodes
    fun getShowAllEpisodes(@Path("id") id: Long): Observable<List<Episodes>>

    @GET("shows/{id}/episodebynumber")  //http://api.tvmaze.com/shows/1/episodebynumber?season=1&number=1
    fun getShowEpisode(@Path("id") id: Long, @Query("season") seasonNumber: String, @Query("number") episodeNumber: String): Observable<Episodes>
}