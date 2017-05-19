package com.flimbis.tvmaze.tv.episode

import com.flimbis.tvmaze.model.EpisodeData

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {
        fun showEpisode(episodes: EpisodeData)

        fun showShowDetails(showid: Long)

    }

    interface Presenter {
        fun loadEpisodes(showid: Long, seasonNum: String, number: String)

        fun navigateToShowDetail(showid: Long)

        fun unbind()
    }
}