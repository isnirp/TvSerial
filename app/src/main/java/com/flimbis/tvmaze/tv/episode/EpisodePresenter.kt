package com.flimbis.tvmaze.tv.episode

import android.util.Log
import com.flimbis.tvmaze.core.entity.Episodes
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.util.convertToEpisodesData
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class EpisodePresenter @Inject constructor(val view: ViewContract.View, val dataSource: TvMazeRepository) : ViewContract.Presenter {

    override fun loadEpisodes(showid: Long, season: String, number: String) {
        dataSource.getSelectedEpisode(showid,season,number, object: EpisodeDataListener {
            override fun onSuccess(episode: Episodes) {
                view.showEpisode(convertToEpisodesData(episode))
            }

            override fun onError(msg: String?) {
                Log.i("EPISODE_API_CALLBack", msg)
            }
        })
    }

    override fun navigateToShowDetail(showid: Long) {
        view.showShowDetails(showid)
    }

    override fun unbind() {
        // no-op
    }
}