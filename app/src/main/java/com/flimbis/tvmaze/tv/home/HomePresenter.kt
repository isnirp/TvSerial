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

    var subscription: Subscription? = null

    override fun loadShows() {

        dataSource.getShowsListByPage("1", object : ShowsListener {
            override fun onSuccess(shows: List<Shows>) {
                view.setupAdapter(convertToShowDataList(shows))
            }

            override fun onError(msg: String?) {
                Log.i("API_CALLBack", "" + msg)
            }
        })

        /*subscription = getShowsInteractorImpl.getShowsPagination("1")
                .subscribe(object: Observer<List<Shows>> {
                    override fun onCompleted() {
                        Log.i("RXXXXX","Completed")
                    }

                    override fun onNext(t: List<Shows>) {
                        Log.i("RXXXXX",""+t.toString())
                        view.setupAdapter(convertToShowDataList(t))
                    }

                    override fun onError(e: Throwable?) {
                        Log.i("RXXXXX","Error")
                    }
                })*/
    }

    override fun navigateToShowsEpisodes(show: ShowsData) {
        view.showEpisodes(show)
    }

    override fun unbind() {
        if (subscription != null && !subscription!!.isUnsubscribed()) {
            subscription!!.unsubscribe();
        }
    }
}
