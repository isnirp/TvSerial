package com.flimbis.tvmaze.tv.shows

import android.util.Log
import com.flimbis.tvmaze.core.entity.ShowEntity
import com.flimbis.tvmaze.core.interactors.GetAllShows
import com.flimbis.tvmaze.core.interactors.UseCaseObserver
import com.flimbis.tvmaze.mapper.ShowsAppDataMapper
import com.flimbis.tvmaze.model.Show
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class ShowsPresenter @Inject constructor(val view: ViewContract.View, val useCase: GetAllShows)
    : ViewContract.Presenter {

    override fun loadShows(pageNumber: Int) {
        useCase.execute(GetShowsListObserver(), pageNumber)
    }

    override fun navigateToDetails(show: Show) {
        view.showMessage(show.name)
    }

    override fun unbind() {
        useCase.dispose()
    }

    inner class GetShowsListObserver : UseCaseObserver<List<ShowEntity>>() {
        override fun onNext(t: List<ShowEntity>) {
            super.onNext(t)
            val mapper = ShowsAppDataMapper()
            view.displayShows(mapper.toModelList(t))
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
        }

        override fun onComplete() {
            super.onComplete()
        }
    }
}
