package com.flimbis.tvmaze.tv.shows.detail

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar
import com.flimbis.tvmaze.AppPreference

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.adapter.EpisodeAdapter
import com.flimbis.tvmaze.di.component.DaggerShowsDetailComponent
import com.flimbis.tvmaze.di.component.ShowsDetailComponent
import com.flimbis.tvmaze.di.module.ShowsDetailModule
import com.flimbis.tvmaze.model.Episode
import com.flimbis.tvmaze.model.Show
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import javax.inject.Inject

class ShowsDetailActivity : AppCompatActivity(),
        ViewContractDetail.View {

    @Inject
    lateinit var presenter: DetailPresenter
    lateinit var banner: ImageView
    lateinit var title: TextView
    lateinit var status: TextView
    lateinit var summary: TextView
    lateinit var list: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //theme
        val theme: Int = AppPreference(this).getCustomTheme()
        setTheme(theme)

        setContentView(R.layout.activity_shows_detail)

        val toolbar: android.support.v7.widget.Toolbar = find(R.id.toolbar_shows_detail)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initViews()

        val show = intent.extras.get("TvShow") as Show
        //toolbar title
        supportActionBar?.title = show.name
        //dagger component
        showsDetailComponent().inject(this)

        presenter.displayIntent(show)
        presenter.loadEpisodes(show.id)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun initViews() {
        banner = find(R.id.img_shows_det)
        title = find(R.id.txt_det_title)
        status = findViewById(R.id.txt_det_status)
        summary = findViewById(R.id.txt_det_summary)
        list = findViewById(R.id.lst_det_episodes)
    }

    fun showsDetailComponent(): ShowsDetailComponent {
        val component: ShowsDetailComponent = DaggerShowsDetailComponent.builder()
                .showsDetailModule(ShowsDetailModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        return component
    }

    override fun displayShows(shows: Show) {
        Picasso.with(this)
                .load(shows.image)
                .into(banner)

        title.text = shows.name
        status.text = shows.status
        summary.text = shows.summary
    }

    override fun displayEpisodes(episodes: List<Episode>) {
        val adapter = EpisodeAdapter(this, episodes)
        list.adapter = adapter

        for (episode in episodes) Log.i("TAG_EP", episode.name)
    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
