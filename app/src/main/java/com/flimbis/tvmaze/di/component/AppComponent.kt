package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.core.executor.ThreadExecutor
import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.remote.ApiService
import com.flimbis.tvmaze.di.module.AppModule
import com.flimbis.tvmaze.di.module.DataSourceModule
import com.flimbis.tvmaze.di.module.NetworkModule
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Component
import io.reactivex.Scheduler

/**
 * Created by Fifi on 5/19/2017.
 */
@ApplicationScope
@Component(modules = arrayOf(AppModule::class, DataSourceModule::class, NetworkModule::class))
interface AppComponent {
    //expose
    fun getApiService(): ApiService
    //fun getRestClient(): TvMazeRestClient
    fun getRepository(): TvMazeRepository
    fun getThreadExecutor(): ThreadExecutor
    fun getUiThreadScheduler(): Scheduler
}