package com.flimbis.tvmaze.data.datasource

import com.flimbis.tvmaze.data.model.Shows

/**
 * Created by Fifi on 12/21/2017.
 */
interface ShowsDataSource {
    fun getAll(): List<Shows>
}