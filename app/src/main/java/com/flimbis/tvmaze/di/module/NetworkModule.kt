package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.data.remote.ApiService
import com.flimbis.tvmaze.di.scope.ApplicationScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class NetworkModule(val baseUrl: String) {
    @Provides
    @ApplicationScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Provides
    @ApplicationScope
    fun provideGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @ApplicationScope
    fun provideGson(): Gson {
        return Gson()
    }

}