package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.di.module.ShowsDetailModule
import com.flimbis.tvmaze.di.scope.CustomScope
import com.flimbis.tvmaze.tv.shows.detail.ShowsDetailActivity
import dagger.Component

@CustomScope
@Component(modules = arrayOf(ShowsDetailModule::class), dependencies = arrayOf(AppComponent::class))
interface ShowsDetailComponent {
    fun inject(showsDetail: ShowsDetailActivity)
}