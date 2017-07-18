package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.interactors.GetShowsList
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.home.ViewContract
import dagger.Module
import dagger.Provides

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
    fun provideGetShowsInteractor(repository: TvMazeRepository): GetShowsList {
        return GetShowsList(repository)
    }
}