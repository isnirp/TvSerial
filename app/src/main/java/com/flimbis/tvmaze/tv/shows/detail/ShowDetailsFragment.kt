package com.flimbis.tvmaze.tv.shows.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.flimbis.tvmaze.R


/**
 * A simple [Fragment] subclass.
 */
class ShowDetailsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_show_details, container, false)
    }

}// Required empty public constructor
