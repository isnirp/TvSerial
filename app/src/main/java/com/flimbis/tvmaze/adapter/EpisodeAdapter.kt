package com.flimbis.tvmaze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.model.Episode
import com.flimbis.tvmaze.util.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by Fifi on 5/19/2017.
 */
class EpisodeAdapter(val context: Context, val episodes: List<Episode>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.items_episodes, parent, false)
            vh = ViewHolder(view)

            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        vh.bindEpisodeItems(episodes[position])

        return view
    }

    override fun getItem(position: Int): Any = episodes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = episodes.size

    inner class ViewHolder(itemView: View) {
        val img: ImageView = itemView.find(R.id.episodes_image)
        val title: TextView = itemView.find(R.id.txt_episodes_name)
        val season_number: TextView = itemView.find(R.id.txt_episodes_season)

        fun bindEpisodeItems(episode: Episode) {
            with(episode) {
                Picasso.with(context)
                        .load(image)
                        .into(img)

                title.text = name
                season_number.text = "season $season"
            }
        }
    }

}