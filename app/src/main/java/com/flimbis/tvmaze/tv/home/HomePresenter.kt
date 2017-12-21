package com.flimbis.tvmaze.tv.home

import android.util.Log
import com.flimbis.tvmaze.core.entity.ShowsEntity
import com.flimbis.tvmaze.core.interactors.GetShowsList
import com.flimbis.tvmaze.core.interactors.UseCase
import com.flimbis.tvmaze.core.interactors.UseCaseObserver
import com.flimbis.tvmaze.core.listeners.ShowsListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.TvMazeDataSource
import com.flimbis.tvmaze.model.ShowsData
import com.flimbis.tvmaze.util.convertToShowDataList
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class HomePresenter @Inject constructor(val view: ViewContract.View, val interactor: GetShowsList) : ViewContract.Presenter {

    override fun loadShows() {
        interactor.execute(GetShowsListObserver(),null)
    }

    override fun navigateToShowsEpisodes(show: ShowsData) {
        view.showEpisodes(show)
    }

    override fun unbind() {
        interactor.dispose()
    }

    private fun displayShowsList(shows: List<ShowsEntity>){
        view.setupAdapter(convertToShowDataList(shows))
    }

    inner class GetShowsListObserver : UseCaseObserver<List<ShowsEntity>>() {
        override fun onNext(t: List<ShowsEntity>) {
            super.onNext(t)
            displayShowsList(t)
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
        }

        override fun onComplete() {
            super.onComplete()
        }
    }
}
