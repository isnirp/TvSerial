package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.executor.ThreadExecutor
import com.flimbis.tvmaze.core.interactors.GetEpisodeDetails
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.episode.detail.ViewContract
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class EpisodeDetailModule(val view: ViewContract.View) {
    @Provides
    @CustomScope
    fun provideView(): ViewContract.View = view

    @Provides
    @CustomScope
    fun provideGetEpisodeDetailsInteractor(repository: TvMazeRepository, threadExecutor: ThreadExecutor, uiThread: Scheduler): GetEpisodeDetails {
        return GetEpisodeDetails(repository, threadExecutor, uiThread)
    }
}