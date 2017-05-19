package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.di.module.EpisodeDetailModule
import com.flimbis.tvmaze.di.module.ShowDetailsModule
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.shows.detail.ShowsDetailActivity
import dagger.Component

/**
 * Created by Fifi on 5/19/2017.
 */
@CustomScope
@Component(modules = arrayOf(ShowDetailsModule::class), dependencies = arrayOf(AppComponent::class))
interface ShowsDetailComponent {
    fun inject(showsDetailActivity: ShowsDetailActivity)
}