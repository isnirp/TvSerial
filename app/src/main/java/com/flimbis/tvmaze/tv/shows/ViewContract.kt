package com.flimbis.tvmaze.tv.shows

import com.flimbis.tvmaze.model.Show

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {
        fun displayShows(shows: List<Show>)

        fun showDetails(show: Show)

        fun showEmptyView()

        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadShows(pageNumber: Int)

        fun navigateToDetails(show: Show)

        fun unbind()
    }
}