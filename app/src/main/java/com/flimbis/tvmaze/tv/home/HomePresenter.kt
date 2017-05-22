package com.flimbis.tvmaze.tv.home

import android.util.Log
import com.flimbis.tvmaze.core.entity.Shows
import com.flimbis.tvmaze.core.interactors.GetShowsInteractorImpl
import com.flimbis.tvmaze.core.listeners.ShowsListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.TvMazeDataSource
import com.flimbis.tvmaze.model.ShowsData
import com.flimbis.tvmaze.util.convertToShowDataList
import rx.Observer
import rx.Subscription
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
//class HomePresenter @Inject constructor(val view: ViewContract.View, val getShowsInteractorImpl: GetShowsInteractorImpl) : ViewContract.Presenter {
class HomePresenter @Inject constructor(val view: ViewContract.View, val dataSource: TvMazeRepository) : ViewContract.Presenter {

    override fun loadShows() {

        dataSource.getShowsListByPage("1", object : ShowsListener {
            override fun onSuccess(shows: List<Shows>) {
                view.setupAdapter(convertToShowDataList(shows))
            }

            override fun onError(msg: String?) {
                Log.i("API_CALLBack", "" + msg)
                view.showMessage("Check network connection")
            }
        })
    }

    override fun navigateToShowsEpisodes(show: ShowsData) {
        view.showEpisodes(show)
    }

    override fun unbind() {

    }
}
