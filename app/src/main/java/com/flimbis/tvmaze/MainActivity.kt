package com.flimbis.tvmaze

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.flimbis.tvmaze.adapter.ShowsAdapter
import com.flimbis.tvmaze.di.component.DaggerShowsComponent
import com.flimbis.tvmaze.di.module.ShowsModule
import com.flimbis.tvmaze.model.ShowsData
import com.flimbis.tvmaze.tv.home.HomePresenter
import com.flimbis.tvmaze.tv.home.ViewContract
import com.flimbis.tvmaze.tv.shows.TvShowActivity
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ViewContract.View, ShowsAdapter.Companion.ClickListener {
    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shows_grid.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.rows))

        //dagger component
        DaggerShowsComponent.builder()
                .showsModule(ShowsModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()
                .inject(this)

        presenter.loadShows()
    }

    override fun setupAdapter(shows: List<ShowsData>) {
        shows_grid.adapter = ShowsAdapter(this, shows).apply {
            setClickListener(this@MainActivity)
        }
    }

    override fun showEpisodes(show: ShowsData) {
        startActivity(TvShowActivity.getIntent(this, show.id, show.image, show.name))
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
