package com.flimbis.tvmaze.tv.shows

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.tv.shows.episodes.ShowEpisodesFragment
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_tv_show.*
import kotlinx.android.synthetic.main.items_shows.view.*

class TvShowActivity : AppCompatActivity(), ViewContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        val intnt = intent
        val id = intnt.getLongExtra("showid",1)
        val showImg = intnt.getStringExtra("showimg")
        val showName = intnt.getStringExtra("showname")
        val type = intnt.getStringExtra("type")


        showBanner(showImg)
        showFragment(type, id)
    }

    override fun showBanner(img: String) {
        Picasso.with(this)
                .load(img)
                .into(backdrop);
    }

    override fun showFragment(type: String, showid: Long) {
        if(type == "episodeList"){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.shows_container, ShowEpisodesFragment.newInstance(showid))
            fragmentTransaction.commit()
        }else{//display show other details

        }
    }
}
