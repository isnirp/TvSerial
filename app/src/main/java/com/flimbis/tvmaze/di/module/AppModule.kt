package com.flimbis.tvmaze.di.module

import android.content.Context
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.di.qualifier.ApplicationContext
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class AppModule(val tvApplication: TvApplication) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context = tvApplication
}