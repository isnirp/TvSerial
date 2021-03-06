package com.flimbis.tvmaze.data.mapper

import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.core.entity.ShowEntity
import com.flimbis.tvmaze.data.model.Shows

/**
 * Created by Fifi on 6/7/2018.
 */
class ShowsDataMapper : Mapper<ShowEntity, Shows>() {
    val scheduleMapper: ScheduleDataMapper = ScheduleDataMapper()

    override fun toEntity(model: Shows): ShowEntity {
        val entity: ShowEntity = ShowEntity()
        entity.id = model.id
        entity.name = model.name
        entity.genres = model.genres
        entity.status = model.status
        entity.schedule = scheduleMapper.toEntity(model.schedule)
        entity.image = model.image.medium
        entity.summary = model.summary
        entity.tvMazeInfo = model.url

        return entity
    }

    override fun toEntityList(modelList: List<Shows>): List<ShowEntity> {
        return modelList.map { showEntity ->
            toEntity(showEntity)
        }
    }

    override fun toModel(entity: ShowEntity): Shows {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModelList(entityList: MutableList<ShowEntity>?): MutableList<Shows> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}