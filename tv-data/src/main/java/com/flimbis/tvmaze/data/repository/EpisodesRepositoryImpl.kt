package com.flimbis.tvmaze.data.repository

import com.flimbis.tvmaze.core.entity.Episode
import com.flimbis.tvmaze.core.repository.EpisodesRepository
import io.reactivex.Observable

/**
 * Created by Fifi on 12/11/2017.
 */
class EpisodesRepositoryImpl : EpisodesRepository {
    override fun getAll(): Observable<MutableList<Episode>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: Long): Observable<Episode> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}