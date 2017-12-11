package com.flimbis.tvmaze.data.model

/**
 * Created by Fifi on 12/11/2017.
 */
data class Image(val medium: String, val original: String)

data class Episodes(val id: Long, val name: String?, val season: Int, val number: Int,
                    val airdate: String, val airtime: String, val runtime: Int, val image: Image, val summary: String?)

data class Schedule( val time: String, val days: List<String>)

data class Shows(val id: Long, val name: String, val language: String,
                 val genres: List<String>, val status: String, val runtime: Int,
                 val premiered: String,val schedule: Schedule, val rating: Double,
                 val image: Image, val summary: String?)