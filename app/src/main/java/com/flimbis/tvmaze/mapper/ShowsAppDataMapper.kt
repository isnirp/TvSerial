package com.flimbis.tvmaze.mapper

import com.flimbis.tvmaze.core.entity.Mapper
import com.flimbis.tvmaze.core.entity.ShowEntity
import com.flimbis.tvmaze.model.Show

/**
 * Created by Fifi on 7/4/2018.
 */

class ShowsAppDataMapper : Mapper<ShowEntity, Show>() {

    override fun toEntity(show: Show): ShowEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toEntityList(showList: List<Show>): List<ShowEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toModel(entity: ShowEntity): Show {
        /*val show = Show(entity.id, entity.name, entity.genres,
                entity.status, entity.schedule.time, entity.schedule.days,
                entity.image ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif",
                entity.summary ?: "no summary", entity.tvMazeInfo)*/
        val show = Show(entity.id, entity.name,
                entity.status,
                entity.image ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif",
                entity.summary ?: "no summary", entity.tvMazeInfo)

        return show
    }

    override fun toModelList(entityList: List<ShowEntity>): List<Show> {
        return entityList.mapIndexed { i, shows ->
            toModel(shows)
        }
    }
}