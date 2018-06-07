package com.flimbis.tvmaze.data.mapper

import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.core.entity.ShowEntity
import com.flimbis.tvmaze.data.model.Shows

/**
 * Created by Fifi on 6/7/2018.
 */
class ShowsDataMapper : Mapper<ShowEntity, Shows>() {
    override fun toEntity(model: Shows): ShowEntity {
        val entity: ShowEntity = ShowEntity()
        entity.id = model.id
        entity.name = model.name
        entity.genres = model.genres
        entity.status = model.status
        entity.schedule.time = model.schedule.time
        entity.schedule.days = model.schedule.days
        entity.image = model.image.medium
        entity.summary = model.summary
        entity.tvMazeInfo = model.url

        return entity
    }

    override fun toEntityList(modelList: MutableList<Shows>?): MutableList<ShowEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModel(entity: ShowEntity): Shows {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModelList(entityList: MutableList<Shows>?): MutableList<ShowEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}