package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.di.module.EpisodesModule
import com.flimbis.tvmaze.di.module.ShowsModule
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.episode.EpisodeActivity
import com.flimbis.tvmaze.tv.episode.EpisodeActivity_MembersInjector
import dagger.Component

/**
 * Created by Fifi on 5/19/2017.
 */
@CustomScope
@Component(modules = arrayOf(EpisodesModule::class), dependencies = arrayOf(AppComponent::class))
interface EpisodesComponent {
    fun inject(episodes: EpisodeActivity)
}