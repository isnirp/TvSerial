package com.flimbis.tvmaze.data.datasource

import com.flimbis.tvmaze.data.model.Shows
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Fifi on 12/21/2017.
 */
interface ShowsDataSource {
    fun getAll(pageNumber: Int): Observable<List<Shows>>

    fun get(id: Long): Single<Shows>
}