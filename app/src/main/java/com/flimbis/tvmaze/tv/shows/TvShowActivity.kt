package com.flimbis.tvmaze.tv.shows

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.tv.shows.episodes.ShowEpisodesFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tv_show.*

class TvShowActivity : AppCompatActivity(), ViewContract.View {

    companion object {
        private val INTENT_SHOW_ID = "showid"
        private val INTENT_SHOW_IMAGE = "showimg"
        private val INTENT_SHOW_NAME = "showname"
        private val INTENT_TYPE = "type"

        /*
            Same paradigm as Fragment.newInstance().
            Could also be extracted as static object.
         */
        fun getIntent(activity: Activity, id: Long, image: String, name: String) = Intent(activity, TvShowActivity::class.java)
                .apply {
                    putExtra(INTENT_SHOW_ID, id)
                    putExtra(INTENT_SHOW_NAME, name)
                    putExtra(INTENT_SHOW_IMAGE, image)
                    putExtra(INTENT_TYPE, "episodeList")
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        intent?.let {
            val id = it.getLongExtra(INTENT_SHOW_ID, 1)
            val showImg = it.getStringExtra(INTENT_SHOW_IMAGE)
            val showName = it.getStringExtra(INTENT_SHOW_NAME)
            val type = it.getStringExtra(INTENT_TYPE)

            showBanner(showImg)
            showFragment(type, id)

        } ?: finish() // no intent -> nothing to show
    }

    override fun showBanner(img: String) {
        // Picasso crash with Illegal Argument Exception when path is empty
        val path = when (img.isNullOrEmpty()) {
            true -> null
            else -> img
        }

        Picasso.with(this)
                .load(path)
                .into(backdrop)
    }

    override fun showFragment(type: String, showid: Long) {
        if (type == "episodeList") {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.shows_container, ShowEpisodesFragment.newInstance(showid))
            fragmentTransaction.commit()

        } else {
            // TODO display show other details
        }
    }
}
