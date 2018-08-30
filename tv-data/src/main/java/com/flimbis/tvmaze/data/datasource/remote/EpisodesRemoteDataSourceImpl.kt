package com.flimbis.tvmaze.data.datasource.remote

import com.flimbis.tvmaze.data.datasource.EpisodesDataSource
import com.flimbis.tvmaze.data.model.Episodes
import io.reactivex.Observable

/**
 * Created by Fifi on 12/21/2017.
 */
class EpisodesRemoteDataSourceImpl(val apiService: ApiService) : EpisodesDataSource {
    override fun getAll(showId: Int): Observable<List<Episodes>> {
        return apiService.getAllEpisodesOfShow(showId)
    }
}