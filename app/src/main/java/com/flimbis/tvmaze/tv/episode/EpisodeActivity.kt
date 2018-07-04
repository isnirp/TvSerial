package com.flimbis.tvmaze.tv.episode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar

import com.flimbis.tvmaze.R
import kotlinx.android.synthetic.main.activity_episode.*
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import javax.inject.Inject

class EpisodeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)

        setSupportActionBar(toolbar_episodes as Toolbar?)
        supportActionBar!!.title = "Episodes"

    }

}
