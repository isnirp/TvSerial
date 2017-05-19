package com.flimbis.tvmaze.util

import com.flimbis.tvmaze.core.entity.Episodes
import com.flimbis.tvmaze.core.entity.Shows
import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.model.ShowsData

/**
 * Created by Fifi on 5/19/2017.
 */
/*fun convertToShowData(shows: Shows): ShowsData {
    val showsdata: ShowsData = ShowsData(shows.id, shows.name, shows.type, shows.language, shows.genres,
            shows.status,shows.runtime,shows.premiered,shows.scheduleTime,shows.scheduleDays,
            shows.rating,shows.networkName,shows.networkCountry,shows.image,shows.summary)

    return showsdata
}*/

fun convertToShowData(shows: Shows): ShowsData {
    val showsdata: ShowsData = ShowsData(shows.id, shows.name, shows.image.medium)

    return showsdata
}

fun convertToShowDataList(list: List<Shows>): List<ShowsData> {
    return list.mapIndexed { i, shows ->
        convertToShowData(shows)
    }
}

fun convertToEpisodesData(episodes: Episodes): EpisodeData {
    val episodedata: EpisodeData = EpisodeData(episodes.id, episodes.name, episodes.season, episodes.number,
            episodes.airdate, episodes.airtime, episodes.runtime, episodes.image.medium, episodes.summary)

    return episodedata
}

fun convertToEpisodeDataList(list: List<Episodes>): List<EpisodeData> {
    return list.mapIndexed { i, episodes ->
        convertToEpisodesData(episodes)
    }
}