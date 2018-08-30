package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.core.repository.EpisodesRepository
import com.flimbis.tvmaze.data.datasource.EpisodesDataSource
import com.flimbis.tvmaze.data.datasource.remote.ApiService
import com.flimbis.tvmaze.data.datasource.remote.EpisodesRemoteDataSourceImpl
import com.flimbis.tvmaze.data.mapper.EpisodesDataMapper
import com.flimbis.tvmaze.data.repository.EpisodesRepositoryImpl
import com.flimbis.tvmaze.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ShowsDetailDataSourceModule {
    @Provides
    @ApplicationScope
    fun provideEpisodesRemoteDataSource(apiService: ApiService): EpisodesDataSource {
        return EpisodesRemoteDataSourceImpl(apiService)
    }

    @Provides
    @ApplicationScope
    fun provideEpisodesDataMapper(): EpisodesDataMapper = EpisodesDataMapper()

    @Provides
    @ApplicationScope
    fun provideEpisodesRepository(dataSource: EpisodesDataSource, mapper: EpisodesDataMapper): EpisodesRepository {
        return EpisodesRepositoryImpl(dataSource, mapper)
    }
}