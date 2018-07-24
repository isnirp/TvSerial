package com.flimbis.tvmaze.data.repository

import android.util.Log
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

    override fun getAll(id: Long): Observable<List<ShowEntity>> {
        Log.i("TAGSHOWS","GET ALL SHOWS CALLED")

        return remote.getAll(1)
                .map(Function { showsList-> mapper.toEntityList(showsList) })
    }

    override fun get(id: Long): Single<ShowEntity> {
        return remote.get(id)
                .map { shows-> mapper.toEntity(shows) }
    }
}