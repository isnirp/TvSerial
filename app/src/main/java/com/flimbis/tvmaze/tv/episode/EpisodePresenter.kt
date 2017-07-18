package com.flimbis.tvmaze.tv.episode

import android.util.Log
import com.flimbis.tvmaze.core.entity.EpisodesEntity
import com.flimbis.tvmaze.core.listeners.EpisodesListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.util.convertToEpisodeDataList
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class EpisodePresenter @Inject constructor(val view: ViewContract.View, val dataSource: TvMazeRepository) : ViewContract.Presenter {

    override fun loadEpisodes(showid: Long) {
        dataSource.getShowEpisodesList(showid, object : EpisodesListener {
            override fun onSuccess(episodes: List<EpisodesEntity>) {
                view.showEpisodes(convertToEpisodeDataList(episodes))
            }

            override fun onError(msg: String?) {
                Log.i("EPISODES_API_CALLBack", "" + msg)
                view.showMessage("Check network connection")
            }
        })
    }

    override fun navigateToEpisodeDetail(episode: EpisodeData) {
        view.showEpisodeDetail(episode)
    }

    override fun unbind() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}