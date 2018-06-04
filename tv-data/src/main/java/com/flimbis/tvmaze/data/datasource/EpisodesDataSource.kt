package com.flimbis.tvmaze.data.datasource

import com.flimbis.tvmaze.data.model.Episodes

/**
 * Created by Fifi on 12/21/2017.
 */
interface EpisodesDataSource {
    fun getAll(): List<Episodes>

    fun getById(id: String): Episodes
}