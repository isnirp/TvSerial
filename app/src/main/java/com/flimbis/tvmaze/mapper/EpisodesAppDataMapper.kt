package com.flimbis.tvmaze.mapper

import com.flimbis.tvmaze.core.entity.EpisodeEntity
import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.model.Episode

/**
 * Created by Fifi on 7/4/2018.
 */
class EpisodesAppDataMapper : Mapper<EpisodeEntity, Episode>() {
    override fun toEntity(episode: Episode?): EpisodeEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toEntityList(episodeList: MutableList<Episode>?): MutableList<EpisodeEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModel(entity: EpisodeEntity): Episode {
        val episode = Episode(entity.id, entity.name, entity.season,
                entity.number, entity.runTime, entity.image ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif",
                entity.summary ?: "no summary")

        return episode
    }

    override fun toModelList(entityList: List<EpisodeEntity>): List<Episode> {
        return entityList.map { entity -> toModel(entity) }
    }
}