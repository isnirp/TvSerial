package com.flimbis.tvmaze.data.repository

import com.flimbis.tvmaze.core.entity.EpisodeEntity
import com.flimbis.tvmaze.core.repository.EpisodesRepository
import com.flimbis.tvmaze.data.datasource.EpisodesDataSource
import com.flimbis.tvmaze.data.mapper.EpisodesDataMapper
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Fifi on 12/11/2017.
 */
class EpisodesRepositoryImpl(val remote: EpisodesDataSource, val mapper: EpisodesDataMapper) : EpisodesRepository {
    override fun getAll(id: Long): Observable<List<EpisodeEntity>> {
       return remote.getAll(id).map { episodesList -> mapper.toEntityList(episodesList) }
    }

    override fun get(id: Long, season: Int, episode: Int): Single<EpisodeEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Long): Single<EpisodeEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}