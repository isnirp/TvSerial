package com.flimbis.tvmaze.model

import java.io.Serializable

/**
 * Created by Fifi on 7/4/2018.
 */
data class Show(val id: Long, val name: String, val status: String,
                val image: String, val summary: String?, val tvMazeInfo: String) : Serializable

