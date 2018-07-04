package com.flimbis.tvmaze.tv.episode.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.di.component.DaggerEpisodeDetailComponent
import com.flimbis.tvmaze.di.component.EpisodeDetailComponent
import com.flimbis.tvmaze.di.module.EpisodeDetailModule
import com.flimbis.tvmaze.tv.shows.TvShowActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_episode_detail.*
import org.jetbrains.anko.longToast
import javax.inject.Inject

class EpisodeDetailActivity : AppCompatActivity(), ViewContract.View {
    @Inject lateinit var presenter: EpisodeDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_detail)

        setSupportActionBar(toolbar_episode_detail as Toolbar?)
        supportActionBar!!.title = "Episode"

        val intnt = intent
        val showid = intnt.getLongExtra("showid", 1)
        val season = intnt.getIntExtra("season", 1)
        val number = intnt.getIntExtra("number", 1)

        val component: EpisodeDetailComponent = DaggerEpisodeDetailComponent.builder()
                .episodeDetailModule(EpisodeDetailModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)

        btn_show_details.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                presenter.navigateToShowDetail(showid)
            }
        })
        presenter.loadEpisodes(showid, season.toString(), number.toString())
    }

    override fun showEpisode(episode: EpisodeData) {
        episodeBanner(episode.image ?: "http://jw-studio.de/wp-content/themes/crowd/images/noimage_2.gif")
        episodeName(episode.name)
        episodeSeason(episode.season)
        episodeNumber(episode.number)
        episodeSummary(episode.summary)
        episodeTime(episode.airtime)
    }

    override fun showShowDetails(showid: Long) {
        val intnt = Intent(this, TvShowActivity::class.java)
        intnt.putExtra("showid", showid)
        startActivity(intnt)
    }

    override fun showMessage(message: String) {
        longToast(message)
    }

    private fun episodeBanner(img: String) {
        Picasso.with(this)
                .load(img)
                .into(img_episode_detail)
    }

    private fun episodeName(name: String) {
        txt_episode_detail_title.text = name
    }

    private fun episodeSummary(summary: String) {
        val s = summary.replace("<p>","")
        txt_episode_detail_summary.text = s.replace("</p>","\n")
    }

    private fun episodeSeason(season: Int) {
        txt_episode_detail_season.text = "season $season"
    }

    private fun episodeNumber(number: Int) {
        txt_episode_detail_number.text = "episode $number"
    }

    private fun episodeTime(time: String) {
        txt_episode_detail_time.text = "time: $time"
    }
}
