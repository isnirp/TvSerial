package com.flimbis.tvmaze.tv.shows.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.di.component.DaggerShowsDetailComponent
import com.flimbis.tvmaze.di.module.ShowDetailsModule
import com.flimbis.tvmaze.model.ShowsData
import javax.inject.Inject

class ShowsDetailActivity : AppCompatActivity(), ViewContract.View {

    @Inject lateinit var presenter: ShowDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shows_detail)

        DaggerShowsDetailComponent.builder()
                .showDetailsModule(ShowDetailsModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()
                .inject(this)
    }

    override fun showDetail(shows: ShowsData) {
        // TODO start intent
    }
}
