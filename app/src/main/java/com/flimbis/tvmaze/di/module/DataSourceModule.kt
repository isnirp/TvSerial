package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.repository.TvMazeRepository
import com.flimbis.tvmaze.data.TvMazeDataSource
import com.flimbis.tvmaze.data.remote.ApiService
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class DataSourceModule {

    @Provides
    @ApplicationScope
    fun provideRepository(apiService: ApiService): TvMazeRepository {
        return TvMazeDataSource(apiService)
    }

}