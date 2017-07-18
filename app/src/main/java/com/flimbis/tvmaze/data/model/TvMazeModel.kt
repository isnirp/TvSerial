package com.flimbis.tvmaze.data.model

/**
 * Created by Fifi on 7/18/2017.
 */

data class Country(val name: String, val code: String, val timezone: String)

data class Network(val id: Int, val name: String, val country: Country)

data class Rating(val average: Double)

data class Schedule(val time: String, val days: List<String>)

data class Image(val medium: String, val original: String)

data class Shows(val id: Long, val name: String, val type: String, val langauge: String, val genres: List<String>,
                 val status: String, val runtime: Int, val premiered: String, val schedule: Schedule,
                 val rating: Rating, val network: Network, val image: Image, val summary: String)

data class Episodes(val id: Long, val name: String, val season: Int, val number: Int, val airdate: String, val airtime: String,
                    val runtime: Int, val image: Image, val summary: String)
