package com.flimbis.tvmaze.model

/**
 * Created by Fifi on 7/4/2018.
 */
data class Show(val id: Long, val name: String, val status: String,
                val image: String, val summary: String?, val tvMazeInfo: String)
/*data class Show(val id: Long, val name: String, val genres: List<String>, val status: String,
                val scheduleTime: String, val scheduleDays: List<String>,
                val image: String, val summary: String?, val tvMazeInfo: String)*/
