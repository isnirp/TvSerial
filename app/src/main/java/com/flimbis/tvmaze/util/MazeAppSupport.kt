package com.flimbis.tvmaze.util

import android.os.Build

inline fun supportsLollipop(code: ()-> Unit){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}