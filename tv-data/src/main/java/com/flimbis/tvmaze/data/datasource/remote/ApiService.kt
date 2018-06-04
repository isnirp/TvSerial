package com.flimbis.tvmaze.data.datasource.remote

import com.flimbis.tvmaze.data.model.Episodes
import com.flimbis.tvmaze.data.model.Seasons
import com.flimbis.tvmaze.data.model.Shows
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Fifi on 12/21/2017.
 */

/*
* The following are a few endpoints to look at from the tv maze api http://www.tvmaze.com/api
* */
interface ApiService {
    /*
    * endpoint http://api.tvmaze.com/shows?page=1
    * paginated 250 items per page
    * */
    @GET("shows")
    fun getAllShows(@Query("page") pageNumber: Long): Observable<List<Shows>>

    /*
    * endpoint http://api.tvmaze.com/shows/1
    * */
    @GET("shows/{id}")
    fun getShowById(@Path("id") id: Long): Single<Shows>

    /*
    * endpoint http://api.tvmaze.com/shows/1/episodes
    * */
    @GET("shows/{id}/episodes")
    fun getAllEpisodesOfShow(@Path("id") id: Long): Observable<List<Episodes>>

    /*
    * endpoint http://api.tvmaze.com/shows/1/episodebynumber?season=1&number=1
    * */
    @GET("shows/{id}/episodebynumber")
    fun getEpisodeOfShow(@Path("id") id: Long, @Query("season") seasonNumber: String, @Query("number") episodeNumber: String): Single<Episodes>

    /*
    * endpoint http://api.tvmaze.com/shows/1/seasons
    * */
    @GET("shows/{id}/seasons")
    fun getAllSeasonsOfShow(@Path("id") id: Long): Observable<List<Seasons>>

    /*
    * endpoint http://api.tvmaze.com/seasons/1/episodes
    * */
    @GET("seasons/{id}/episodes")
    fun getAllEpisodesOfSeasons(@Path("id") id: Long): Observable<List<Episodes>>
}