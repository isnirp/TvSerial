package com.flimbis.tvmaze.tv.episode

import android.util.Log
import com.flimbis.tvmaze.core.entity.EpisodesEntity
import com.flimbis.tvmaze.core.interactors.GetAllEpisodes
import com.flimbis.tvmaze.core.interactors.UseCaseObserver
import com.flimbis.tvmaze.core.listeners.EpisodesListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.util.convertToEpisodeDataList
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class EpisodePresenter @Inject constructor(val view: ViewContract.View, val interator: GetAllEpisodes) : ViewContract.Presenter {

    override fun loadEpisodes(showid: Long) {
        interator.execute(GetEpisodesListObserver(), null)
    }

    override fun navigateToEpisodeDetail(episode: EpisodeData) {
        view.showEpisodeDetail(episode)
    }

    override fun unbind() {
        interator.dispose()
    }

    private fun displayEpisodesList(episodes: List<EpisodesEntity>){
        view.showEpisodes(convertToEpisodeDataList(episodes))
    }

    inner class GetEpisodesListObserver : UseCaseObserver<List<EpisodesEntity>>() {
        override fun onNext(t: List<EpisodesEntity>) {
            super.onNext(t)
            displayEpisodesList(t)
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
        }

        override fun onComplete() {
            super.onComplete()
        }
    }
}