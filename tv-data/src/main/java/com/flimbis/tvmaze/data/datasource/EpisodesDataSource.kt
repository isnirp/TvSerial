package com.flimbis.tvmaze.data.datasource

import com.flimbis.tvmaze.data.model.Episodes
import io.reactivex.Observable

/**
 * Created by Fifi on 12/21/2017.
 */
interface EpisodesDataSource {
    fun getAll(showId: Int): Observable<List<Episodes>>
}