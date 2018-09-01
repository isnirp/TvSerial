package com.flimbis.tvmaze.tv.shows.detail

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar

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

    val DEF_THEME = "def"
    val CINEMA_THEME = "cinema"

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
        setTheme(getSavedTheme())
        setContentView(R.layout.activity_shows_detail)

        val toolbar: android.support.v7.widget.Toolbar = find(R.id.toolbar_shows_detail)
        setSupportActionBar(toolbar)

        initViews()

        showsDetailComponent().inject(this)

        val show = intent.extras.get("TvShow") as Show

        //toolbar title
        supportActionBar?.title = show.name

        presenter.displayIntent(show)
        presenter.loadEpisodes(show.id)
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
        for(episode in episodes) Log.i("TAG_EP", episode.name)

        val adapter = EpisodeAdapter(this, episodes)
        list.adapter = adapter
    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun saveTheme(value: String){
        val editor: SharedPreferences.Editor = getPreferences(0).edit()
        editor.putString("theme", value)
        editor.commit()
        recreate()
    }

    fun getSavedTheme(): Int {
        val theme: String = getPreferences(0).getString("theme",DEF_THEME)
        val value: Int
        when(theme){
            DEF_THEME-> value = R.style.AppTheme_Def
            CINEMA_THEME -> value = R.style.AppTheme_Cinema
            else -> value = R.style.AppTheme_Cinema
        }

        return value
    }
}
