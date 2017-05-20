package com.flimbis.tvmaze.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.adapter.ShowsAdapter.Companion.ViewHolder
import com.flimbis.tvmaze.model.ShowsData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_shows.view.*

/**
 * Created by Fifi on 5/19/2017.
 */
class ShowsAdapter(val context: Context, val shows: List<ShowsData>) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        interface ClickListener {
            fun itemClicked(show: ShowsData)
        }
    }

    var callback: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.items_shows, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.apply {
            val show: ShowsData = shows[position]
            val img_url = when (show.image.isNullOrEmpty()) {
                true -> null
                else -> show.image
            }
            //load image
            Picasso.with(context).load(img_url).into(itemView.img_shows)
            itemView.txt_shows_name.text = show.name
            itemView.setOnClickListener({ callback?.itemClicked(show) })
        }
    }

    override fun getItemCount() = shows.size

    fun setClickListener(clickListener: ClickListener?) {
        this.callback = clickListener
    }
}