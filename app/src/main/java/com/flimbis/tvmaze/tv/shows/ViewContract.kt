package com.flimbis.tvmaze.tv.shows

/**
 * Created by Fifi on 5/19/2017.
 */
interface ViewContract {
    interface View {
        fun showBanner(img: String)

        fun showFragment(type: String, showid: Long)
    }

    interface Presenter {
        fun loadBanner(img: String)

        fun replaceFragment(type: String)

        fun unbind()
    }
}