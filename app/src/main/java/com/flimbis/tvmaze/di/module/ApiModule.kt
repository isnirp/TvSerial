package com.flimbis.tvmaze.di.module

import com.flimbis.tvmaze.data.datasource.remote.ApiService
import com.flimbis.tvmaze.di.scope.ApplicationScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory




/**
 * Created by Fifi on 5/19/2017.
 */
@Module
class ApiModule(val baseUrl: String) {
    @Provides
    @ApplicationScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(converterFactory: Converter.Factory, callAdapter: CallAdapter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapter)
                .build();
    }

    @Provides
    @ApplicationScope
    fun provideGsonConverterFactory(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    @ApplicationScope
    fun provideGson(): Gson = Gson()

    @Provides
    @ApplicationScope
    fun provideCallAdapterFactory(): CallAdapter.Factory =  RxJava2CallAdapterFactory.create()

}