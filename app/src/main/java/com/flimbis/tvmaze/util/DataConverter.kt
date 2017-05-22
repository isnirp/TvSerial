package com.flimbis.tvmaze.util

import com.flimbis.tvmaze.core.entity.Episodes
import com.flimbis.tvmaze.core.entity.Shows
import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.model.ShowsData

/**
 * Created by Fifi on 5/19/2017.
 */
fun convertToShowData(shows: Shows): ShowsData {
    val showsdata: ShowsData = ShowsData(shows.id, shows.name, shows.type, shows.language, shows.genres,
            shows.status, shows.runtime, shows.premiered ?: "not available", shows.schedule.time, shows.schedule.days, shows.rating.average ?: 0.0,
            shows.image.medium ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif", shows.summary ?: "no summary")

    return showsdata
}

fun convertToShowDataList(list: List<Shows>): List<ShowsData> {
    return list.mapIndexed { i, shows ->
        convertToShowData(shows)
    }
}

fun convertToEpisodesData(episodes: Episodes): EpisodeData {
    val episodedata: EpisodeData = EpisodeData(episodes.id, episodes.name, episodes.season ?: 1, episodes.number?: 1,
            episodes.airdate, episodes.airtime, episodes.runtime,
            episodes.image?.medium ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif",
            episodes.summary ?: "no summary")

    return episodedata
}

fun convertToEpisodeDataList(list: List<Episodes>): List<EpisodeData> {
    return list.mapIndexed { i, episodes ->
        convertToEpisodesData(episodes)
    }
}