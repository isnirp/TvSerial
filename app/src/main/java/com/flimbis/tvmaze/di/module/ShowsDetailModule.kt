package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.interactors.GetAllEpisodes
import com.flimbis.tvmaze.core.repository.EpisodesRepository
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.shows.detail.ViewContractDetail
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class ShowsDetailModule(val view: ViewContractDetail.View) {
    @Provides
    @CustomScope
    fun provideView(): ViewContractDetail.View = view

    @Provides
    @CustomScope
    fun provideGetEpisodesUseCase(repository: EpisodesRepository, uiThread: Scheduler): GetAllEpisodes {
        return GetAllEpisodes(repository, uiThread)
    }
}