package com.flimbis.tvmaze.tv.shows.detail

import com.flimbis.tvmaze.model.Episode
import com.flimbis.tvmaze.model.Show

interface ViewContractDetail {
    interface View {
        fun displayShows(shows: Show)

        fun displayEpisodes(episodes: Episode)

        fun showMessage(msg: String)
    }

    interface Presenter {
        fun displayIntent(shows: Show)

        fun loadEpisodes(id: Int)

        fun unbind()
    }
}