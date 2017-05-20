package com.flimbis.tvmaze.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.adapter.EpisodeAdapter.Companion.ViewHolder
import com.flimbis.tvmaze.model.EpisodeData
import kotlinx.android.synthetic.main.items_episodes.view.*

/**
 * Created by Fifi on 5/19/2017.
 */
class EpisodeAdapter(val context: Context, val episodes: List<EpisodeData>) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        /*
            Inner classes will always have a memory reference to the main class.
            Use static classes if possible to avoid memory leaks.
         */
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        interface ClickListener {
            fun itemClicked(episode: EpisodeData)
        }
    }

    var callback: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.items_episodes, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.apply {
            val episode: EpisodeData = episodes[position]
            itemView.txt_episodes_name.text = episode.name
            itemView.setOnClickListener({ callback?.itemClicked(episode) })
        }
    }

    override fun getItemCount() = episodes.size

    /*
        I think it make sense to allow nullable values on nullable delegates.
        So that the using UI Layer can unbind its delegate.
     */
    fun setClickListener(clickListener: ClickListener?) {
        this.callback = clickListener
    }
}