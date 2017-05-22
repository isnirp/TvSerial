package com.flimbis.tvmaze.tv.episode

import com.flimbis.tvmaze.model.EpisodeData

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {
        fun showEpisodes(episodes: List<EpisodeData>)

        fun showEpisodeDetail(episode: EpisodeData)

        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadEpisodes(showid: Long)

        fun navigateToEpisodeDetail(episode: EpisodeData)

        fun unbind()
    }
}