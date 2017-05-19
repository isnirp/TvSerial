package com.flimbis.tvmaze.tv.shows.episodes


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.adapter.EpisodeAdapter
import com.flimbis.tvmaze.di.component.DaggerEpisodesComponent
import com.flimbis.tvmaze.di.component.EpisodesComponent
import com.flimbis.tvmaze.di.module.EpisodesModule
import com.flimbis.tvmaze.model.EpisodeData
import kotlinx.android.synthetic.main.fragment_show_episodes.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ShowEpisodesFragment : Fragment(), ViewContract.View, EpisodeAdapter.ClickListener {
    var showId: Long? = null
    @Inject lateinit var presenter: ShowEpisodesPresenter

    companion object {
        fun newInstance(id: Long): ShowEpisodesFragment {
            var args: Bundle = Bundle()
            args.putLong("showsid", id)
            var episodesFragment: ShowEpisodesFragment = newInstance()
            episodesFragment.arguments = args
            return episodesFragment
        }

        fun newInstance(): ShowEpisodesFragment {
            return ShowEpisodesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_show_episodes, container, false)
        if (arguments != null) {
            showId = arguments.getLong("showsid")
        }


        val component: EpisodesComponent = DaggerEpisodesComponent.builder()
                .episodesModule(EpisodesModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()

        component.inject(this)

        presenter.loadEpisodes(arguments.getLong("showsid"))

        return view
    }

    override fun showEpisodes(episodes: List<EpisodeData>) {
        val mAdapter: EpisodeAdapter = EpisodeAdapter(context, episodes)
        //set adapter
        episodes_list.layoutManager = LinearLayoutManager(context)
        episodes_list.adapter = mAdapter
        //set click listener
        mAdapter.setClickListener(this)
    }

    override fun showEpisodeDetail(episode: EpisodeData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun itemClicked(episode: EpisodeData) {
        presenter.navigateToEpisodeDetail(episode)
    }
}
