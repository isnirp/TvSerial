package com.flimbis.tvmaze.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.model.ShowsData
import com.flimbis.tvmaze.util.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_shows.view.*

/**
 * Created by Fifi on 5/19/2017.
 */
class ShowsAdapter(val shows: List<ShowsData>, val itemClick: (ShowsData)-> Unit) : RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {

    var callback: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent?.ctx).inflate(R.layout.items_shows, parent, false)
        return ViewHolder(v, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val show: ShowsData = shows[position]

        holder?.bindShows(show)
    }

    override fun getItemCount(): Int = shows.size

    class ViewHolder(itemView: View, val itemClick: (ShowsData)-> Unit) : RecyclerView.ViewHolder(itemView){
        fun bindShows(show: ShowsData){
            with(show){
                itemView.txt_shows_name.text = show.name
                Picasso.with(itemView.ctx)
                        .load(show.image)
                        .into(itemView.img_shows);

                itemView.setOnClickListener{itemClick(this)}
            }
        }
    }

    interface ClickListener {
        fun itemClicked(show: ShowsData)
    }
}