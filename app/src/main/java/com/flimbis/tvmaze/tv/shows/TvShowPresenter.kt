package com.flimbis.tvmaze.tv.shows

import android.util.Log
import com.flimbis.tvmaze.core.entity.ShowsEntity
import com.flimbis.tvmaze.core.interactors.GetShow
import com.flimbis.tvmaze.core.interactors.Param
import com.flimbis.tvmaze.core.interactors.UseCaseObserver
import com.flimbis.tvmaze.core.listeners.ShowDataListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.util.convertToShowData
import javax.inject.Inject

/**
 * Created by Fifi on 5/20/2017.
 */
class TvShowPresenter @Inject constructor(val view: ViewContract.View, val interactor: GetShow) : ViewContract.Presenter {

    override fun loadShow(showid: Long) {
        val p: Param = Param(showid)
        interactor.execute(GetShowDetailsObserver(), p)
    }

    override fun unbind() {
        interactor.dispose()
    }

    private fun displayDetails(showsEntity: ShowsEntity){
        view.showShowDetail(convertToShowData(showsEntity))
    }

    inner class GetShowDetailsObserver : UseCaseObserver<ShowsEntity>() {
        override fun onNext(t: ShowsEntity) {
            super.onNext(t)
            displayDetails(t)
        }

        override fun onError(e: Throwable?) {
            super.onError(e)
        }

        override fun onComplete() {
            super.onComplete()
        }
    }

}