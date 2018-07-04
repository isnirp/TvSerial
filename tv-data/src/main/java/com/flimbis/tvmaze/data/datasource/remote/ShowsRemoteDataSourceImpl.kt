package com.flimbis.tvmaze.data.datasource.remote

import com.flimbis.tvmaze.data.datasource.ShowsDataSource
import com.flimbis.tvmaze.data.model.Shows
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Fifi on 12/21/2017.
 */
class ShowsRemoteDataSourceImpl(val apiService: ApiService) : ShowsDataSource {
    override fun getAll(pageNumber: Int): Observable<MutableList<Shows>> = apiService.getAllShows(pageNumber)

    override fun get(id: Long): Single<Shows> = apiService.getShowById(id)
}