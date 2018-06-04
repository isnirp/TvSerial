package com.flimbis.tvmaze.data.datasource.remote

import com.flimbis.tvmaze.data.datasource.EpisodesDataSource
import com.flimbis.tvmaze.data.model.Episodes

/**
 * Created by Fifi on 12/21/2017.
 */
class EpisodesRemoteDataSourceImpl(val apiService: ApiService) : EpisodesDataSource {
    override fun getAll(): List<Episodes> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: String): Episodes {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}