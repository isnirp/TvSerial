package com.flimbis.tvmaze.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flimbis.tvmaze.R
import com.flimbis.tvmaze.model.ShowsData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_shows.view.*

/**
 * Created by Fifi on 5/19/2017.
 */
class ShowsAdapter(val context: Context, val shows: List<ShowsData>) : RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {

    var callback: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.items_shows, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val show: ShowsData = shows[position]
        //(holder as ViewHolder).bindData(show)
        val hold = holder as ViewHolder
        //views
        hold.itemView.txt_shows_name.text = show.name
        //load image
        val img_url = show.image
        Picasso.with(context)
                .load(img_url)
                .into(hold.itemView.img_shows);

        hold.itemView.setOnClickListener(View.OnClickListener { callback?.itemClicked(show) })
    }

    override fun getItemCount(): Int = shows.size

    fun setClickListener(clickListener: ClickListener){
        this.callback = clickListener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ClickListener {
        fun itemClicked(show: ShowsData)
    }
}