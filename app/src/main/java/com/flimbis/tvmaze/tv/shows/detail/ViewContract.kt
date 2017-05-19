package com.flimbis.tvmaze.tv.shows.detail

import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.model.ShowsData

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {

        fun showDetail(shows: ShowsData)
    }

    interface Presenter {
        fun loadShow(showid: Long)

        fun unbind()
    }
}