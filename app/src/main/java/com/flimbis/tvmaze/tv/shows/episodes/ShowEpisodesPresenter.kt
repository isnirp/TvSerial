package com.flimbis.tvmaze.tv.shows.episodes

import android.util.Log
import com.flimbis.tvmaze.core.entity.Episodes
import com.flimbis.tvmaze.core.listeners.EpisodesListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.util.convertToEpisodeDataList
import rx.Subscription
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class ShowEpisodesPresenter @Inject constructor(val view: ViewContract.View, val dataSource: TvMazeRepository) : ViewContract.Presenter {
    var subscription: Subscription? = null

    override fun loadEpisodes(showid: Long) {
        dataSource.getShowEpisodesList(showid, object : EpisodesListener {
            override fun onSuccess(episodes: List<Episodes>) {
                view.showEpisodes(convertToEpisodeDataList(episodes))
            }

            override fun onError(msg: String?) {
                Log.i("EPISODES_API_CALLBack", "" + msg)
            }
        })
    }

    override fun navigateToEpisodeDetail(episode: EpisodeData) {
        view.showEpisodeDetail(episode)
    }

    override fun unbind() {
        if (subscription != null && !subscription!!.isUnsubscribed()) {
            subscription!!.unsubscribe();
        }
    }
}