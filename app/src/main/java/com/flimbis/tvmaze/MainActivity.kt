package com.flimbis.tvmaze

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.flimbis.tvmaze.adapter.ShowsAdapter
import com.flimbis.tvmaze.di.component.DaggerShowsComponent
import com.flimbis.tvmaze.di.component.ShowsComponent
import com.flimbis.tvmaze.di.module.ShowsModule
import com.flimbis.tvmaze.model.ShowsData
import com.flimbis.tvmaze.tv.home.HomePresenter
import com.flimbis.tvmaze.tv.home.ViewContract
import com.flimbis.tvmaze.tv.shows.TvShowActivity
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ViewContract.View, ShowsAdapter.ClickListener {
    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shows_grid.layoutManager = GridLayoutManager(this, 4)

        //dagger component
        val component: ShowsComponent = DaggerShowsComponent.builder()
                .showsModule(ShowsModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)

        presenter.loadShows()
    }

    override fun setupAdapter(shows: List<ShowsData>) {
        val adapter: ShowsAdapter = ShowsAdapter(this, shows)
        shows_grid.adapter = adapter
        adapter.setClickListener(this)
    }

    override fun showEpisodes(show: ShowsData) {
        val intnt = Intent(this, TvShowActivity::class.java)
        intnt.putExtra("showid", show.id)
        intnt.putExtra("showname", show.name)
        intnt.putExtra("showimg", show.image)
        intnt.putExtra("type", "episodeList")
        startActivity(intnt)
    }

    override fun showEmptyView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun itemClicked(show: ShowsData) {
        presenter.navigateToShowsEpisodes(show)
    }
}
