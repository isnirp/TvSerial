package com.flimbis.tvmaze.tv.episode.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View

import com.flimbis.tvmaze.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_episode_detail.*
import org.jetbrains.anko.longToast
import javax.inject.Inject

class EpisodeDetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_detail)

        setSupportActionBar(toolbar_episode_detail as Toolbar?)
        supportActionBar!!.title = "Episode"

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
