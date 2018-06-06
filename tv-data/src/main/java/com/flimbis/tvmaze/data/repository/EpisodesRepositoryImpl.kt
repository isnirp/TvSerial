package com.flimbis.tvmaze.data.repository

import com.flimbis.tvmaze.core.entity.EpisodeEntity
import com.flimbis.tvmaze.core.repository.EpisodesRepository
import com.flimbis.tvmaze.data.datasource.EpisodesDataSource
import io.reactivex.Observable

/**
 * Created by Fifi on 12/11/2017.
 */
class EpisodesRepositoryImpl(val remote: EpisodesDataSource, val local: EpisodesDataSource) : EpisodesRepository {
    override fun getAll(): Observable<MutableList<EpisodeEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: Long): Observable<EpisodeEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllPerShow(showId: Long): Observable<MutableList<EpisodeEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Long, season: Int, episode: Int): Observable<EpisodeEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}