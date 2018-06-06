package com.flimbis.tvmaze.data.repository

import com.flimbis.tvmaze.core.entity.ShowEntity
import com.flimbis.tvmaze.core.repository.ShowsRepository
import com.flimbis.tvmaze.data.datasource.ShowsDataSource
import io.reactivex.Observable

/**
 * Created by Fifi on 12/11/2017.
 */
class ShowsRepositoryImpl(val remote: ShowsDataSource, val local: ShowsDataSource) : ShowsRepository {
    override fun getAll(): Observable<MutableList<ShowEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: Long): Observable<ShowEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllPerPage(page: Int): Observable<MutableList<ShowEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}