package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.shows.detail.ViewContract
import dagger.Module
import dagger.Provides

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class ShowDetailsModule(val view: ViewContract.View) {
    @Provides
    @CustomScope
    fun provideView(): ViewContract.View = view
}