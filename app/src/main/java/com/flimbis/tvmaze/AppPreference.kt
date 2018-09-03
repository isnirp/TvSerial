package com.flimbis.tvmaze

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AppPreference(val context: Activity) {
    val pref: SharedPreferences
    val editor: SharedPreferences.Editor

    companion object {
        val prefName = "APP_PREF"
        val DEF_THEME = "DEFAULT"
        val CINEMA_THEME = "CINEMA"
    }

    init {
        pref = context.getSharedPreferences(prefName, 0)
        editor = pref.edit()
    }

    fun setCustomTheme(theme: String){
        editor.putString("theme", theme)
        editor.commit()
        context.recreate()
    }

    fun getCustomTheme(): Int {
        val theme: String = pref.getString("theme",DEF_THEME)
        val value: Int
        when(theme){
            DEF_THEME-> value = R.style.AppTheme_Def
            CINEMA_THEME -> value = R.style.AppTheme_Cinema
            else -> value = R.style.AppTheme_Def
        }

        return value
    }
}