package com.flimbis.tvmaze.data.mapper

import com.flimbis.tvmaze.core.entity.EpisodeEntity
import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.data.model.Episodes

/**
 * Created by Fifi on 6/7/2018.
 */
class EpisodesDataMapper : Mapper<EpisodeEntity, Episodes>() {
    override fun toEntity(model: Episodes): EpisodeEntity {
        val entity = EpisodeEntity()
        entity.id = model.id
        entity.name = model.name
        entity.season = model.season
        entity.number = model.number
        entity.runTime = model.runtime
        entity.image = model.image.medium
        entity.summary = model.summary

        return entity
    }

    override fun toEntityList(modelList: List<Episodes>): List<EpisodeEntity> {
        return modelList.map { episodes -> toEntity(episodes) }
    }

    override fun toModel(entity: EpisodeEntity?): Episodes {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModelList(entityList: MutableList<EpisodeEntity>?): MutableList<Episodes> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}