package com.flimbis.tvmaze

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.startActivity
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_splash)

        val trd = Thread {
            try {
                sleep(2500)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        trd.start()
        trd.join()

        startActivity<MainActivity>()*/

    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}
