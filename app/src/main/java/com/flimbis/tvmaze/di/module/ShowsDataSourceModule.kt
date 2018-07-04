package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.repository.ShowsRepository
import com.flimbis.tvmaze.data.datasource.ShowsDataSource
import com.flimbis.tvmaze.data.datasource.remote.ApiService
import com.flimbis.tvmaze.data.datasource.remote.ShowsRemoteDataSourceImpl
import com.flimbis.tvmaze.data.mapper.ShowsDataMapper
import com.flimbis.tvmaze.data.repository.ShowsRepositoryImpl
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class ShowsDataSourceModule {
    @Provides
    @ApplicationScope
    fun provideRemoteDataSource(apiService: ApiService): ShowsDataSource {
        return ShowsRemoteDataSourceImpl(apiService)
    }

    @Provides
    @ApplicationScope
    fun provideDataMapper(): ShowsDataMapper = ShowsDataMapper()

    @Provides
    @ApplicationScope
    fun provideShowsRepository(remote: ShowsDataSource, mapper: ShowsDataMapper): ShowsRepository {
        return ShowsRepositoryImpl(remote, mapper)
    }
}