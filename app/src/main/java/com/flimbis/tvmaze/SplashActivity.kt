package com.flimbis.tvmaze

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splash_layout.postDelayed({startActivity<MainActivity>()}, 2500)
    }
}
