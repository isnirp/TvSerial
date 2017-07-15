package com.flimbis.tvmaze

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.flimbis.tvmaze.adapter.ShowsAdapter
import com.flimbis.tvmaze.di.component.DaggerShowsComponent
import com.flimbis.tvmaze.di.component.ShowsComponent
import com.flimbis.tvmaze.di.module.ShowsModule
import com.flimbis.tvmaze.model.ShowsData
import com.flimbis.tvmaze.tv.episode.EpisodeActivity
import com.flimbis.tvmaze.tv.home.HomePresenter
import com.flimbis.tvmaze.tv.home.ViewContract
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ViewContract.View {
    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "TvAmaze"

        shows_grid.layoutManager = GridLayoutManager(this, 3)

        //dagger component
        val component: ShowsComponent = DaggerShowsComponent.builder()
                .showsModule(ShowsModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)

        presenter.loadShows()
    }

    override fun setupAdapter(shows: List<ShowsData>) {
        //val adapter: ShowsAdapter = ShowsAdapter(shows) {show -> presenter.navigateToShowsEpisodes(show)}
        val adapter: ShowsAdapter = ShowsAdapter(shows) {presenter.navigateToShowsEpisodes(it)}//use it where parameter is one
        shows_grid.adapter = adapter
    }

    override fun showEpisodes(show: ShowsData) {
        val intnt = Intent(this, EpisodeActivity::class.java)
        intnt.putExtra("showid", show.id)
        startActivity(intnt)
    }

    override fun showEmptyView() {

    }

    override fun showMessage(message: String) {
        longToast(message)
    }
}
