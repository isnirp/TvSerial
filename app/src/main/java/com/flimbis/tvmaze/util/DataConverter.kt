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

fun convertToShowData(shows: Shows) = ShowsData(shows.id, shows.name, shows.image.medium)

fun convertToShowDataList(list: List<Shows>) = list.mapIndexed { _, shows ->
    convertToShowData(shows)
}

fun convertToEpisodesData(episodes: Episodes) = EpisodeData(
        episodes.id, episodes.name, episodes.season, episodes.number,
        episodes.airdate, episodes.airtime, episodes.runtime,
        episodes.image?.medium ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif",
        episodes.summary ?: "no summary")

fun convertToEpisodeDataList(list: List<Episodes>) = list.mapIndexed { _, episodes ->
    convertToEpisodesData(episodes)
}