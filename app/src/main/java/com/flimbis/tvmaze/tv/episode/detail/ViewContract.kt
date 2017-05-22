package com.flimbis.tvmaze.tv.episode.detail

import com.flimbis.tvmaze.model.EpisodeData

/**
 * Created by Fifi on 5/20/2017.
 */
interface ViewContract {
    interface View {
        fun showEpisode(episode: EpisodeData)

        fun showShowDetails(showid: Long)

        fun showMessage(message: String)

    }

    interface Presenter {
        fun loadEpisodes(showid: Long, season: String, number: String)

        fun navigateToShowDetail(showid: Long)

        fun unbind()
    }
}