package com.flimbis.tvmaze.data.repository

import com.flimbis.tvmaze.core.entity.Show
import com.flimbis.tvmaze.core.repository.ShowsRepository
import io.reactivex.Observable

/**
 * Created by Fifi on 12/11/2017.
 */
class ShowsRepositoryImpl : ShowsRepository {
    override fun getAll(): Observable<MutableList<Show>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: Long): Observable<Show> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}