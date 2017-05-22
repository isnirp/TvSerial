package com.flimbis.tvmaze.model

/**
 * Created by Fifi on 5/19/2017.
 */
data class ShowsData(val id: Long, val name: String, val type: String, val language: String,
                     val genres: List<String>, val status: String, val runtime: Int,
                     val premiered: String, val scheduletime: String, val scheduledays: List<String>, val rating: Double,
                     val image: String, val summary: String)
