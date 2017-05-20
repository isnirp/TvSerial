package com.flimbis.tvmaze.tv.shows.episodes


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.adapter.EpisodeAdapter
import com.flimbis.tvmaze.di.component.DaggerEpisodesComponent
import com.flimbis.tvmaze.di.module.EpisodesModule
import com.flimbis.tvmaze.model.EpisodeData
import kotlinx.android.synthetic.main.fragment_show_episodes.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ShowEpisodesFragment : Fragment(), ViewContract.View, EpisodeAdapter.Companion.ClickListener {

    /*
        This can be tricky... lateinit could end in crash so be careful.

        Imagine what would happen if public method itemClicked is called before Injection is done.
        ShowEpisodeFragment.newInstance(1).itemCLicked(episodeData) --> NPE
     */
    @Inject
    lateinit var presenter: ShowEpisodesPresenter

    val showId: Long by lazy { arguments?.getLong(ARGUMENT_SHOW_ID, -1) ?: -1 }

    companion object {
        private val ARGUMENT_SHOW_ID = "showid"

        fun newInstance(id: Long) = ShowEpisodesFragment().apply {
            arguments = Bundle().apply {
                putLong(ARGUMENT_SHOW_ID, id)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?) = inflater?.inflate(R.layout.fragment_show_episodes, container, false).apply {

        DaggerEpisodesComponent.builder()
                .episodesModule(EpisodesModule(this@ShowEpisodesFragment))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()
                .inject(this@ShowEpisodesFragment)

        presenter.loadEpisodes(showId)
    }

    override fun showEpisodes(episodes: List<EpisodeData>) {
        episodes_list.layoutManager = LinearLayoutManager(context)
        //set adapter & click listener
        episodes_list.adapter = EpisodeAdapter(context, episodes).apply {
            setClickListener(this@ShowEpisodesFragment)
        }
    }

    override fun showEpisodeDetail(episode: EpisodeData) {
        view?.let {
            Toast.makeText(it.context, "comming soon", Toast.LENGTH_SHORT).show()
        }
    }

    override fun itemClicked(episode: EpisodeData) {
        presenter.navigateToEpisodeDetail(episode)
    }
}
