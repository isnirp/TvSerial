package com.flimbis.tvmaze.tv.episode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.adapter.EpisodeAdapter
import com.flimbis.tvmaze.di.component.DaggerEpisodeDetailComponent
import com.flimbis.tvmaze.di.component.DaggerEpisodesComponent
import com.flimbis.tvmaze.di.component.EpisodeDetailComponent
import com.flimbis.tvmaze.di.component.EpisodesComponent
import com.flimbis.tvmaze.di.module.EpisodeDetailModule
import com.flimbis.tvmaze.di.module.EpisodesModule
import com.flimbis.tvmaze.model.EpisodeData
import com.flimbis.tvmaze.tv.episode.detail.EpisodeDetailActivity
import kotlinx.android.synthetic.main.activity_episode.*
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import javax.inject.Inject

class EpisodeActivity : AppCompatActivity(), ViewContract.View, EpisodeAdapter.ClickListener {
    @Inject lateinit var presenter: EpisodePresenter

    var id: Long? = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)

        setSupportActionBar(toolbar_episodes as Toolbar?)
        supportActionBar!!.title = "Episodes"

        val intnt = intent
        id = intnt.getLongExtra("showid", 1)

        val component: EpisodesComponent = DaggerEpisodesComponent.builder()
                .episodesModule(EpisodesModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)

        presenter.loadEpisodes(id!!)

    }

    override fun showEpisodes(episodes: List<EpisodeData>) {
        val mAdapter: EpisodeAdapter = EpisodeAdapter(this, episodes)

        val episodeslist: RecyclerView = find(R.id.episodes_list)
        //set adapter
        episodeslist.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        episodeslist.adapter = mAdapter
        episodeslist.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //set click listener
        mAdapter.setClickListener(this)

    }

    override fun showEpisodeDetail(episode: EpisodeData) {
        val intnt = Intent(this, EpisodeDetailActivity::class.java)
        intnt.putExtra("showid", id )
        intnt.putExtra("season", episode.season)
        intnt.putExtra("number", episode.number)

        startActivity(intnt)
    }

    override fun showMessage(message: String) {
        longToast(message)
    }

    override fun itemClicked(episode: EpisodeData) {
        presenter.navigateToEpisodeDetail(episode)
    }
}
