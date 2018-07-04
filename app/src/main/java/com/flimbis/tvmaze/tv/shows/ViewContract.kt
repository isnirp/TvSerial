package com.flimbis.tvmaze.tv.shows

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {
        fun showShowDetail(shows: ShowsData)

        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadShow(showid: Long)

        fun unbind()
    }
}