package com.flimbis.tvmaze.tv.episode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.di.component.DaggerEpisodeDetailComponent
import com.flimbis.tvmaze.di.component.EpisodeDetailComponent
import com.flimbis.tvmaze.di.module.EpisodeDetailModule
import com.flimbis.tvmaze.model.EpisodeData
import javax.inject.Inject

class EpisodeActivity : AppCompatActivity(), ViewContract.View {
    @Inject lateinit var presenter: EpisodePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)

        val component: EpisodeDetailComponent = DaggerEpisodeDetailComponent.builder()
                .episodeDetailModule(EpisodeDetailModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)


    }

    override fun showEpisode(episodes: EpisodeData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showShowDetails(showid: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
