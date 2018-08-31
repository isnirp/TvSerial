package com.flimbis.tvmaze.tv.shows.detail

import com.flimbis.tvmaze.core.entity.EpisodeEntity
import com.flimbis.tvmaze.core.interactors.GetAllEpisodes
import com.flimbis.tvmaze.core.interactors.UseCaseObserver
import com.flimbis.tvmaze.mapper.EpisodesAppDataMapper
import com.flimbis.tvmaze.model.Show
import javax.inject.Inject

class DetailPresenter @Inject constructor(val view: ViewContractDetail.View, val episodesUseCase: GetAllEpisodes)
    : ViewContractDetail.Presenter {

    override fun displayIntent(shows: Show) {
        view.displayShows(shows)
    }

    override fun loadEpisodes(id: Long) {
        episodesUseCase.execute(GetAllEpisodesObserver(), id)
    }

    override fun unbind() {
        episodesUseCase.dispose()
    }

    inner class GetAllEpisodesObserver : UseCaseObserver<List<EpisodeEntity>>() {
        override fun onNext(t: List<EpisodeEntity>) {
            super.onNext(t)
            view.displayEpisodes(EpisodesAppDataMapper().toModelList(t))
        }

        override fun onError(e: Throwable) {
            super.onError(e)
        }

        override fun onComplete() {
            super.onComplete()
        }
    }
}