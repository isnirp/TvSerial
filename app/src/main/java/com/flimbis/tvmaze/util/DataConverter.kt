package com.flimbis.tvmaze.util

import com.flimbis.tvmaze.core.entity.EpisodesEntity
import com.flimbis.tvmaze.core.entity.ShowsEntity
import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.model.ShowsData

/**
 * Created by Fifi on 5/19/2017.
 */
fun convertToShowData(showsEntity: ShowsEntity): ShowsData {
    val showsdata: ShowsData = ShowsData(showsEntity.id, showsEntity.name, showsEntity.type, showsEntity.language, showsEntity.genres,
            showsEntity.status, showsEntity.runtime, showsEntity.premiered ?: "not available", showsEntity.schedule.time, showsEntity.schedule.days, showsEntity.rating.average ?: 0.0,
            showsEntity.image.medium ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif", showsEntity.summary ?: "no summary")

    return showsdata
}

fun convertToShowDataList(list: List<ShowsEntity>): List<ShowsData> {
    return list.mapIndexed { i, shows ->
        convertToShowData(shows)
    }
}

fun convertToEpisodesData(episodesEntity: EpisodesEntity): EpisodeData {
    val episodedata: EpisodeData = EpisodeData(episodesEntity.id, episodesEntity.name, episodesEntity.season ?: 1, episodesEntity.number?: 1,
            episodesEntity.airdate, episodesEntity.airtime, episodesEntity.runtime,
            episodesEntity.image?.medium ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif",
            episodesEntity.summary ?: "no summary")

    return episodedata
}

fun convertToEpisodeDataList(list: List<EpisodesEntity>): List<EpisodeData> {
    return list.mapIndexed { i, episodes ->
        convertToEpisodesData(episodes)
    }
}