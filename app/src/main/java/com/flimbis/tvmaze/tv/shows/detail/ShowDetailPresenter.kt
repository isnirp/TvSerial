package com.flimbis.tvmaze.tv.shows.detail

import android.util.Log
import com.flimbis.tvmaze.core.entity.Shows
import com.flimbis.tvmaze.core.listeners.ShowDataListener
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.util.convertToShowData
import javax.inject.Inject

/**
 * Created by Fifi on 5/19/2017.
 */
class ShowDetailPresenter @Inject constructor(val view: ViewContract.View, val dataSource: TvMazeRepository) : ViewContract.Presenter {

    override fun loadShow(showid: Long) {
        dataSource.getSelectedShowById(showid,object: ShowDataListener {
            override fun onSuccess(show: Shows) {
                view.showDetail(convertToShowData(show))
            }

            override fun onError(msg: String?) {
                Log.i("SHOWS_API_CALLBack", "" + msg)
            }
        })
    }

    override fun unbind() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}