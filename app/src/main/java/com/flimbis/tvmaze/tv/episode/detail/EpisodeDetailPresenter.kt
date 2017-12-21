package com.flimbis.tvmaze.tv.episode.detail

import android.util.Log
import com.flimbis.tvmaze.core.entity.EpisodesEntity
import com.flimbis.tvmaze.core.interactors.GetEpisode
import com.flimbis.tvmaze.core.interactors.Param
import com.flimbis.tvmaze.core.interactors.UseCaseObserver
import com.flimbis.tvmaze.core.listeners.EpisodeDataListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.util.convertToEpisodesData
import javax.inject.Inject

/**
 * Created by Fifi on 5/20/2017.
 */
class EpisodeDetailPresenter @Inject constructor(val view: ViewContract.View, val interactor: GetEpisode)
    : ViewContract.Presenter {

    override fun loadEpisodes(showid: Long, season: String, number: String) {
        val p: Param = Param(showid, season, number)
        interactor.execute(GetEpisodeDetailsObserver(), p)
    }

    override fun navigateToShowDetail(showid: Long) {
        view.showShowDetails(showid)
    }

    override fun unbind() {
        interactor.dispose()
    }

    private fun displayEpisodeDetails(episodesEntity: EpisodesEntity) {
        view.showEpisode(convertToEpisodesData(episodesEntity))
    }

    inner class GetEpisodeDetailsObserver : UseCaseObserver<EpisodesEntity>() {
        override fun onNext(t: EpisodesEntity) {
            super.onNext(t)
            displayEpisodeDetails(t)
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
        }

        override fun onComplete() {
            super.onComplete()
        }
    }
}