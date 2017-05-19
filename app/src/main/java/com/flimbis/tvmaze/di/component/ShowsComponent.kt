package com.flimbis.tvmaze.di.component

import com.flimbis.tvmaze.MainActivity
import com.flimbis.tvmaze.di.module.ShowsModule
import com.flimbis.tvmaze.di.scope.CustomScope
import dagger.Component

/**
 * Created by Fifi on 5/19/2017.
 */
@CustomScope
@Component(modules = arrayOf(ShowsModule::class), dependencies = arrayOf(AppComponent::class))
interface ShowsComponent {
    fun inject(mainActivity: MainActivity)
}