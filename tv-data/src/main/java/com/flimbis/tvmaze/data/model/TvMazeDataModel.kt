package com.flimbis.tvmaze.data.model

/**
 * Created by Fifi on 12/11/2017.
 */
data class Image(val medium: String, val original: String)

data class Episodes(val id: Long, val name: String?, val season: Int, val number: Int,
                    val runtime: Int, val image: Image, val summary: String?)

data class Seasons(val id: Long, val number: Int, val name: String?, val episodeOrder: Int, val premiereDate: String, val endDate: String,
                   val image: Image, val summary: String?)

data class Schedule(val time: String, val days: List<String>)

data class Shows(val id: Long, val url: String, val name: String, val genres: List<String>, val status: String,
                 val schedule: Schedule, val image: Image, val summary: String?)