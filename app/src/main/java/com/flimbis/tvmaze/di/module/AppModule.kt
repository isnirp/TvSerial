package com.flimbis.tvmaze.di.module

import android.content.Context
import com.flimbis.tvmaze.TvApplication
import com.flimbis.tvmaze.core.executor.ThreadExecutor
import com.flimbis.tvmaze.di.qualifier.ApplicationContext
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class AppModule(val tvApplication: TvApplication) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context = tvApplication

    @Provides
    @ApplicationScope
    fun provideThreadExecutor(): ThreadExecutor = ThreadExecutor()

    @Provides
    @ApplicationScope
    fun provideUiThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}