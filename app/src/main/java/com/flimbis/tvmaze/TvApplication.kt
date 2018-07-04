package com.flimbis.tvmaze

import android.app.Application
import com.flimbis.tvmaze.di.component.AppComponent
import com.flimbis.tvmaze.di.component.DaggerAppComponent
import com.flimbis.tvmaze.di.module.AppModule
import com.flimbis.tvmaze.di.module.ApiModule

/**
 * Created by Fifi on 5/19/2017.
 */
class TvApplication : Application() {

    companion object {
        lateinit var INSTANCE: TvApplication

        fun getInstance(): TvApplication {
            INSTANCE = TvApplication()
            return INSTANCE
        }
    }

    override fun onCreate() {
        super.onCreate()
        getAppComponent()
    }

    fun getAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(ApiModule("http://api.tvmaze.com/"))
                .build()
    }
}