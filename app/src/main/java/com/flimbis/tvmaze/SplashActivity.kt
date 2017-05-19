package com.flimbis.tvmaze

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.startActivity
import android.content.Intent
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val trd = Thread(Runnable {
            try {
                sleep(2500)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                startActivity<MainActivity>()
            }
        })

        trd.start()

    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}
