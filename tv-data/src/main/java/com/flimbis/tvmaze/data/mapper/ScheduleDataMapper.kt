package com.flimbis.tvmaze.data.mapper

import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.core.entity.ScheduleEntity
import com.flimbis.tvmaze.data.model.Schedule

/**
 * Created by Fifi on 7/24/2018.
 */
class ScheduleDataMapper : Mapper<ScheduleEntity, Schedule>() {
    override fun toEntity(model: Schedule): ScheduleEntity {
        return ScheduleEntity(model.time, model.days)
    }

    override fun toEntityList(modelList: MutableList<Schedule>?): MutableList<ScheduleEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModel(entity: ScheduleEntity?): Schedule {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModelList(entityList: MutableList<ScheduleEntity>?): MutableList<Schedule> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}