package com.flimbis.tvmaze.data.model

import com.flimbis.tvmaze.core.entity.*

/**
 * Created by Fifi on 7/18/2017.
 */

fun transformToShowsEntity(shows: Shows): ShowsEntity {
    val showsEntity = ShowsEntity()
    showsEntity.id = shows.id
    showsEntity.name = shows.name
    showsEntity.type = shows.type
    showsEntity.language = shows.langauge
    showsEntity.genres = shows.genres
    showsEntity.status = shows.status
    showsEntity.runtime = shows.runtime
    showsEntity.premiered = shows.premiered
    convertToScheduleEntity(shows.schedule)
    convertToRatingEntity(shows.rating)
    convertToNetworkEntity(shows.network)
    convertToImageEntity(shows.image)
    showsEntity.summary = shows.summary

    return showsEntity
}

fun transformToShowsEntityList(list: List<Shows>): List<ShowsEntity> {
    return list.mapIndexed { i, shows ->
        transformToShowsEntity(shows)
    }
}

fun transformToEpisodesEntity(episodes: Episodes): EpisodesEntity {
    val episodesEntity = EpisodesEntity()
    episodesEntity.id = episodes.id
    episodesEntity.name = episodes.name
    episodesEntity.season = episodes.season
    episodesEntity.number = episodes.number
    episodesEntity.airdate = episodes.airdate
    episodesEntity.airtime = episodes.airtime
    episodesEntity.runtime = episodes.runtime
    convertToImageEntity(episodes.image)
    episodesEntity.summary = episodes.summary

    return episodesEntity
}
fun transformToEpisodesEntityList(list: List<Episodes>): List<EpisodesEntity> {
    return list.mapIndexed { i, episodes ->
        transformToEpisodesEntity(episodes)
    }
}

fun convertToScheduleEntity(schedule: Schedule): ScheduleEntity {
    val scheduleEntity = ScheduleEntity()
    scheduleEntity.days = schedule.days
    scheduleEntity.time = schedule.time

    return scheduleEntity
}

fun convertToRatingEntity(rating: Rating): RatingEntity {
    val ratingEntity = RatingEntity()
    ratingEntity.average = rating.average

    return ratingEntity
}

fun convertToNetworkEntity(network: Network): NetworkEntity {
    val networkEntity = NetworkEntity()
    networkEntity.country.name = network.country.name
    networkEntity.country.code = network.country.code
    networkEntity.country.timezone = network.country.timezone
    networkEntity.id = network.id
    networkEntity.name = network.name

    return networkEntity
}

fun convertToImageEntity(image: Image): ImageEntity {
    val imageEntity = ImageEntity()
    imageEntity.medium = image.medium
    imageEntity.original = image.original
    return imageEntity
}