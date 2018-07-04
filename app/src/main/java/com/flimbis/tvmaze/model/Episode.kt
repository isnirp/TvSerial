package com.flimbis.tvmaze.model

/**
 * Created by Fifi on 7/4/2018.
 */
data class Episode(val id: Long, val name: String, val season: Int, val number: Int,
                   val runtime: Int, val image: String?, val summary: String?)