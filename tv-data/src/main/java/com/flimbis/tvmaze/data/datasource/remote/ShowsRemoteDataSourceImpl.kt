package com.flimbis.tvmaze.data.datasource.remote

import com.flimbis.tvmaze.data.datasource.ShowsDataSource
import com.flimbis.tvmaze.data.model.Shows

/**
 * Created by Fifi on 12/21/2017.
 */
class ShowsRemoteDataSourceImpl(val apiService: ApiService) : ShowsDataSource {
    override fun getAll(): List<Shows> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}