package com.flimbis.tvmaze.tv.shows.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.model.Episode
import com.flimbis.tvmaze.model.Show
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import javax.inject.Inject

class ShowsDetailActivity : AppCompatActivity(),
        ViewContractDetail.View{

    @Inject lateinit var presenter:DetailPresenter
    lateinit var banner: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shows_detail)

        initViews()

        val show = intent.extras.get("TvShow") as Show
        presenter.displayIntent(show)
    }

    fun initViews(){
        banner = find(R.id.img_shows_det)
    }

    fun getComponent(){

    }

    override fun displayShows(shows: Show) {
        Picasso.with(this)
                .load(shows.image)
                .into(banner)
    }

    override fun displayEpisodes(episodes: Episode) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
