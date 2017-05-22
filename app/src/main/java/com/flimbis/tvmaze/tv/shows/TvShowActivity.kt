package com.flimbis.tvmaze.tv.shows

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.di.component.DaggerShowsDetailComponent
import com.flimbis.tvmaze.di.component.ShowsDetailComponent
import com.flimbis.tvmaze.di.module.ShowDetailsModule
import com.flimbis.tvmaze.model.ShowsData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tv_show.backdrop

import kotlinx.android.synthetic.main.activity_tv_show.*
import kotlinx.android.synthetic.main.items_shows.view.*
import org.jetbrains.anko.longToast
import javax.inject.Inject

class TvShowActivity : AppCompatActivity(), ViewContract.View {
    @Inject lateinit var presenter: TvShowPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        setSupportActionBar(toolbar_show_detail as Toolbar?)


        val intnt = intent
        val id = intnt.getLongExtra("showid", 1)

        val component: ShowsDetailComponent = DaggerShowsDetailComponent.builder()
                .showDetailsModule(ShowDetailsModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)

        presenter.loadShow(id)

    }

    override fun showShowDetail(show: ShowsData) {
        showBanner(show.image)
        showName(show.name)
        showSummary(show.summary)
        showLanguage(show.language)
        showStatus(show.status)
        showTime(show.scheduletime)
        showDays(show.scheduledays)
        showGenres(show.genres)
    }

    override fun showMessage(message: String) {
        longToast(message)
    }

    private fun showBanner(img: String) {
        Picasso.with(this)
                .load(img)
                .into(backdrop)
    }

    private fun showName(name: String) {
        //set toolbar title
        supportActionBar!!.title = name
        txt_show_detail_name.text = name

    }

    private fun showSummary(summary: String) {
        val s = summary.replace("<p>", "")
        txt_show_detail_summary.text = s.replace("</p>", "\n")
    }

    private fun showStatus(status: String) {
        txt_show_detail_status.text = "status: $status"
    }

    private fun showLanguage(lang: String) {
        txt_show_detail_language.text = "language $lang"
    }

    private fun showDays(days: List<String>) {
        for (day: String in days)
            txt_show_detail_days.text = "Days: $day"
    }

    private fun showTime(time: String) {
        txt_show_detail_time.text = "Time $time"
    }

    private fun showGenres(genres: List<String>) {
        for (genre: String in genres)
            txt_show_detail_genres.text = genre
    }
}
