package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.interactors.GetAllShows
import com.flimbis.tvmaze.core.repository.ShowsRepository
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.home.ViewContract
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class ShowsModule(val view: ViewContract.View) {
    @Provides
    @CustomScope
    fun provideView(): ViewContract.View = view

    @Provides
    @CustomScope
    fun provideGetShowsUseCase(repository: ShowsRepository, uiThread: Scheduler): GetAllShows {
        return GetAllShows(repository, uiThread)
    }
}