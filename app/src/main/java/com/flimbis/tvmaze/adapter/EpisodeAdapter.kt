package com.flimbis.tvmaze.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.model.EpisodeData
import kotlinx.android.synthetic.main.items_episodes.view.*

/**
 * Created by Fifi on 5/19/2017.
 */
class EpisodeAdapter (val context: Context, val episodes: List<EpisodeData>) : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    var callback: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.items_episodes, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val episode: EpisodeData = episodes[position]
        val hold = holder as ViewHolder
        //views
        hold.itemView.txt_episodes_name.text = episode.name

        hold.itemView.setOnClickListener(View.OnClickListener { callback?.itemClicked(episode) })
    }

    override fun getItemCount(): Int = episodes.size

    fun setClickListener(clickListener: ClickListener){
        this.callback = clickListener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ClickListener {
        fun itemClicked(episode: EpisodeData)
    }
}