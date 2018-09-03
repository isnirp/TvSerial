package com.flimbis.tvmaze

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //setTheme(defaultTheme())
    }

    //private fun defaultTheme(): Int = AppPreference(this).getCustomTheme()
    protected fun defaultTheme() = setTheme(AppPreference(this).getCustomTheme())

    protected fun getApplicationComponent() = TvApplication.getInstance().getAppComponent()
}