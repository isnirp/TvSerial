package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.di.module.EpisodeDetailModule
import com.flimbis.tvmaze.di.module.EpisodesModule
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.episode.EpisodeActivity
import dagger.Component

/**
 * Created by Fifi on 5/19/2017.
 */
@CustomScope
@Component(modules = arrayOf(EpisodeDetailModule::class), dependencies = arrayOf(AppComponent::class))
interface EpisodeDetailComponent {
    fun inject(episodeActivity: EpisodeActivity)
}