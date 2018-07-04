package com.flimbis.tvmaze.data.repository

import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.core.entity.ShowEntity
import com.flimbis.tvmaze.core.repository.ShowsRepository
import com.flimbis.tvmaze.data.datasource.ShowsDataSource
import com.flimbis.tvmaze.data.mapper.ShowsDataMapper
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function

/**
 * Created by Fifi on 12/11/2017.
 */
class ShowsRepositoryImpl(val remote: ShowsDataSource, val mapper: ShowsDataMapper) : ShowsRepository {

    override fun getAll(id: Long): Observable<MutableList<ShowEntity>> {
        return remote.getAll(id.toInt())
                .map(Function { showsList-> mapper.toEntityList(showsList) })
    }

    override fun get(id: Long): Single<ShowEntity> {
        return remote.get(id)
                .map { shows-> mapper.toEntity(shows) }
    }
}