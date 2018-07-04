package com.flimbis.tvmaze.tv.home

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {
        fun setupAdapter(shows: List<ShowsData>)

        fun showEpisodes(show: ShowsData)

        fun showEmptyView()

        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadShows()

        fun navigateToShowsEpisodes(show: ShowsData)

        fun unbind()
    }
}