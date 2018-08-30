package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.core.repository.EpisodesRepository
import com.flimbis.tvmaze.core.repository.ShowsRepository
import com.flimbis.tvmaze.data.datasource.remote.ApiService
import com.flimbis.tvmaze.di.module.AppModule
import com.flimbis.tvmaze.di.module.ShowsDataSourceModule
import com.flimbis.tvmaze.di.module.ApiModule
import com.flimbis.tvmaze.di.module.ShowsDetailDataSourceModule
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Component
import io.reactivex.Scheduler

/**
 * Created by Fifi on 5/19/2017.
 */
@ApplicationScope
@Component(modules = arrayOf(AppModule::class, ShowsDataSourceModule::class, ShowsDetailDataSourceModule::class,ApiModule::class))
interface AppComponent {
    //expose
    fun getApiService(): ApiService
    fun getShowsRepository(): ShowsRepository
    fun getEpisodesRepository(): EpisodesRepository
    fun getUiThreadScheduler(): Scheduler
}