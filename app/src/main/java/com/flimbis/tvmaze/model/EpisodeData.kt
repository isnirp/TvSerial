package com.flimbis.tvmaze.model

/**
 * Created by Fifi on 5/19/2017.
 */

data class EpisodeData (val id: Long, val name: String, val season: Int, val number: Int,
                        val airdate: String, val airtime: String, val runtime: Int,
                        val image: String?, val summary: String)

